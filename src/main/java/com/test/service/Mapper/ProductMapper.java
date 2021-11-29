package com.test.service.Mapper;

import com.test.dto.ProductDTO;
import com.test.entity.Product;
import com.test.in.ProductIn;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDTO map(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDistributors(product.getDistributors());
        return productDTO;
    }

    public static Product map(ProductIn productIn) {
        Product product = new Product();
        if (productIn.getName() != null){
            product.setId(productIn.getId());
        }
        product.setName(productIn.getName());
        product.setPrice(productIn.getPrice());
        product.setDistributors(productIn.getDistributors());
        return product;
    }

}
