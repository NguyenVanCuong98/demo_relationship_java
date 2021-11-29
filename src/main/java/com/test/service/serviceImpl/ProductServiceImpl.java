package com.test.service.serviceImpl;

import com.test.dto.CardDto;
import com.test.dto.ProductDTO;
import com.test.entity.Distributor;
import com.test.entity.Product;
import com.test.in.ProductIn;
import com.test.repository.DistributorRepository;
import com.test.repository.ProductRepository;
import com.test.service.Mapper.ProductMapper;
import com.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Autowired
    private DistributorRepository distributorRepository;
    @Override
    public List<ProductDTO> getAll() {

        List<Product> list = productRepository.findAll();
        List<ProductDTO> dtoList = list.stream().map(it -> productMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Product create(ProductIn productIn) {
        Product product = ProductMapper.map(productIn);
        return productRepository.save(product);
    }

    @Override
    public Product update(Integer id,ProductIn productIn) {
        Product product = productRepository.findById(id).orElse(null);
        productIn.setId(id);
        if (productIn.getDistributors() == null){
            Collection<Distributor> distributor = product.getDistributors();
            productIn.setDistributors(distributor);

        }else {
            List<Distributor> distributors = (List<Distributor>) productIn.getDistributors();

            for (int i = 0; i < distributors.size();i++){
                if (distributors.get(i).getAddress() == null){
                    Distributor distributor = distributorRepository.findById(distributors.get(i).getId()).orElse(null);
                    distributors.set(i,distributor);
                }
            }
            productIn.setDistributors(distributors);
        }
        product = ProductMapper.map(productIn);
        return productRepository.save(product);
    }

    @Override
    public void delete(Integer id,ProductIn productIn) {
        Product product = productRepository.findById(id).orElse(null);
        product.setDistributors(null);
        productRepository.save(product);

        productRepository.deleteById(id);
    }
}
