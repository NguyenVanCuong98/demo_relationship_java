package com.test.controller;

import com.test.dto.ProductDTO;
import com.test.entity.Product;
import com.test.in.ProductIn;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getAll () {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Product> create (@RequestBody ProductIn productIn) {
        return new ResponseEntity<>(productService.create(productIn), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete (@PathVariable Integer id,@RequestBody ProductIn productIn) {
         productService.delete(id,productIn);
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public Product update(@PathVariable Integer id,@RequestBody ProductIn productIn){
        return productService.update(id,productIn);
    }
//
}
