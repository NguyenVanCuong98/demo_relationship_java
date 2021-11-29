package com.test.dto;

import com.test.entity.Card;
import com.test.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private Integer id;
    private Integer money;
    private String title;
    private Customer customer;
}
