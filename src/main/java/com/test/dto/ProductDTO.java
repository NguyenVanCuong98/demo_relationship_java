package com.test.dto;
import com.test.entity.Distributor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private Integer price;
    private Collection<Distributor> distributors;
}
