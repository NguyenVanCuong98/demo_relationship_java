package com.test.in;


import com.test.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class DistributorIn {
    private Integer id;
    private String name;
    private String address;
    private Collection<Product> products;
}
