package com.test.in;

import com.test.entity.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerIn {
    private String name;
    private Integer age;
    private Integer IdCard;
    private Card card;
}
