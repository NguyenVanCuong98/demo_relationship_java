package com.test.service.serviceImpl;


import com.test.dto.CustomerDto;
import com.test.entity.Card;
import com.test.entity.Customer;
import com.test.in.CustomerIn;
import com.test.repository.CardRepository;
import com.test.repository.CustomerRepository;
import com.test.service.CardService;
import com.test.service.CustomerService;
import com.test.service.Mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public List<CustomerDto> getAllCustomer() {
        List<Customer> list = customerRepository.findAll();
        List<CustomerDto> dtoList = list.stream().map(it -> customerMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Customer createCustomer(CustomerIn customerIn) {
        Customer customer = customerMapper.map(customerIn);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer id, CustomerIn customerIn) {
        Customer customer = customerRepository.findById(id).orElse(null);
        Integer idCard = customerIn.getIdCard();
        if (idCard == null){
            Card card = customer.getCard();
            card.setCustomer(null);
            cardRepository.save(card);
            customer.setCard(null);
            cardRepository.save(card);
        }
        customerRepository.deleteById(id);

    }


    @Override
    public Customer updateCustomer(CustomerIn customerIn,Integer id) {

        Customer customer = customerRepository.findCustomerById(id);

        Card card = customer.getCard();
        if (customerIn.getIdCard() != null){
            card = cardRepository.findCardsById(customerIn.getIdCard());
            Customer customerOld = card.getCustomer();
            card.setCustomer(null);
            if (customerOld != null){
                customerOld.setCard(null);
                customerRepository.save(customerOld);
            }
            cardRepository.save(card);
        }
        if (customerIn.getCard() != null){
            card = customerIn.getCard();
        }
        customerMapper.map(customerIn, customer);
        customer.setCard(card);
        Customer response = customerRepository.save(customer);
        return response;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        return customer;
    }
}
