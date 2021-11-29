package com.test.service.serviceImpl;

import com.test.dto.CardDto;
import com.test.entity.Card;
import com.test.entity.Customer;
import com.test.in.CardIn;
import com.test.repository.CardRepository;
import com.test.repository.CustomerRepository;
import com.test.service.CardService;
import com.test.service.Mapper.CardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CustomerRepository customerRepository;
    private CardMapper cardMapper;
    @Override
    public List<CardDto> getAllCard() {
        List<Card> cards = cardRepository.findAll();
        List<CardDto> cardDtos = cards.stream().map(it -> cardMapper.map(it)).collect(Collectors.toList());
        return  cardDtos;
    }

    @Override
    public Card createCard(CardDto cardDto) {
        Card card = CardMapper.map(cardDto);
        return cardRepository.save(card);
    }
    @Override
    public void deleteCard(Integer id) {
        Card card = findById(id);
        if (card.getCustomer() != null){
            Customer customer = card.getCustomer();
            card.setCustomer(null);
            customer.setCard(null);
            customerRepository.save(customer);
        }
        cardRepository.delete(card);
    }


    @Override
    public Card updateCard(CardIn cardIn, Integer id){
        Card card1 = cardRepository.findById(id).orElse(null);

        Customer customer1 = card1.getCustomer();
        if (cardIn.getIdCustomer() != null){
            customer1 = customerRepository.findById(cardIn.getIdCustomer()).orElse(null);
            Card cardOld = customer1.getCard();
            customer1.setCard(null);
            if (cardOld != null){
                cardOld.setCustomer(null);
                cardRepository.save(cardOld);
            }
            customerRepository.save(customer1);
        }
        if (cardIn.getCustomer() != null){
            customer1 = cardIn.getCustomer();
        }
        Card card = cardMapper.map(cardIn,id, customer1);
        Card response = cardRepository.save(card);
        return response;
    }

    @Override
    public Card findById(Integer id) {
        return cardRepository.findCardsById(id);
    }
}
