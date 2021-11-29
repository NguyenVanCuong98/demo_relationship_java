package com.test.dto;


import com.test.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
public class DistributorDTO {
    private Integer id;
    private String name;
    private String address;
    private Collection<Product> products;
}
