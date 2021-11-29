package com.test.service;

import com.test.dto.CustomerDto;
import com.test.entity.Customer;
import com.test.in.CustomerIn;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomer();
    Customer createCustomer(CustomerIn customerIn);
    void deleteCustomer(Integer id,CustomerIn idCard);
    Customer updateCustomer(CustomerIn customerIn,Integer id) ;
    Customer findById(Integer id);
}
