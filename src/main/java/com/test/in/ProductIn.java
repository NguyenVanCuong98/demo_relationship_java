package com.test.in;


import com.test.entity.Distributor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class  ProductIn {
    private Integer id;
    private String name;
    private Integer price;
    private Collection<Distributor> distributors;
}
