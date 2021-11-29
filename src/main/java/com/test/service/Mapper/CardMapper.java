package com.test.service.Mapper;

import com.test.dto.CardDto;
import com.test.entity.Card;
import com.test.entity.Customer;
import com.test.in.CardIn;


public class CardMapper {


    public static Card map(CardDto cardDto){

        Card card = new Card();
        card.setMoney(cardDto.getMoney());
        card.setTitle(cardDto.getTitle());
        card.setCustomer(cardDto.getCustomer());
        return card;
    }


    public static CardDto map(Card card){

        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setMoney(card.getMoney());
        cardDto.setTitle(card.getTitle());
        cardDto.setCustomer(card.getCustomer());
        return cardDto;
    }
    public static Card map(CardIn cardIn, Integer id, Customer customer){

        Card card = new Card();
        card.setId(id);
        card.setMoney(cardIn.getMoney());
        card.setTitle(cardIn.getTitle());
        card.setCustomer(customer);
        return card;
    }

}
