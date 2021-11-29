package com.test.service;

import com.test.dto.ProductDTO;
import com.test.entity.Product;
import com.test.in.ProductIn;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    Product create(ProductIn productIn);
    Product update(Integer id,ProductIn productIn);
    void delete(Integer id,ProductIn productIn);
}
