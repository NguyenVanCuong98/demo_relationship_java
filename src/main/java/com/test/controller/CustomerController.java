package com.test.controller;

import com.test.dto.CardDto;
import com.test.dto.CustomerDto;
import com.test.entity.Card;
import com.test.entity.Customer;
import com.test.in.CustomerIn;
import com.test.service.CardService;
import com.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {
    @Autowired

    CustomerService customerService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDto>> getAllCustomer () {
        List<CustomerDto> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer , HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public Customer create(@RequestBody CustomerIn customerIn){
        return customerService.createCustomer(customerIn);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Customer update(@RequestBody CustomerIn customerIn, @PathVariable Integer id) {
        Customer customer = customerService.updateCustomer(customerIn,id);
        return customer;
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id,@RequestBody CustomerIn idCard){
        customerService.deleteCustomer(id,idCard);
    }

}
