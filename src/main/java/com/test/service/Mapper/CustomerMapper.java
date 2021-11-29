package com.test.service.Mapper;


import com.test.dto.CustomerDto;
import com.test.entity.Card;
import com.test.entity.Customer;
import com.test.in.CustomerIn;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public static CustomerDto map(Customer customer){

        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setAge(customer.getAge());
        customerDto.setName(customer.getName());
        customerDto.setCard(customer.getCard());
        return customerDto;
    }
    public Customer map(CustomerIn customerIn,Card card,Integer id) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerIn.getName());
        customer.setAge(customerIn.getAge());
        customer.setCard(card);
        return customer;
    }
    public Customer map(CustomerIn customerUpdateIn, Customer customer) {
//        customer.setId(id);
        customer.setName(customerUpdateIn.getName());
        customer.setAge(customerUpdateIn.getAge());
        customer.setCard(customerUpdateIn.getCard());
        return customer;
    }
    public Customer map(CustomerIn customerIn) {
        Customer customer = new Customer();
        customer.setName(customerIn.getName());
        customer.setAge(customerIn.getAge());
        customer.setCard(customerIn.getCard());
        return customer;
    }
}
