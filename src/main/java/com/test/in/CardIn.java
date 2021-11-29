package com.test.in;

import com.test.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardIn {
    private Integer idCustomer;
    private Integer money;
    private String title;
    private Customer customer;
}
