package com.test.service.serviceImpl;

import com.test.dto.CardDto;
import com.test.dto.DistributorDTO;
import com.test.entity.Distributor;
import com.test.entity.Product;
import com.test.in.DistributorIn;
import com.test.repository.DistributorRepository;
import com.test.repository.ProductRepository;
import com.test.service.DistributorService;
import com.test.service.Mapper.DistributorMapper;
import com.test.service.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;
    private DistributorMapper distributorMapper;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<DistributorDTO> getAll() {
                List<Distributor> list =  distributorRepository.findAll();
        List<DistributorDTO> dtoList = list.stream().map(it -> distributorMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public Distributor create(DistributorIn distributorIn) {
        Distributor distributor = DistributorMapper.map(distributorIn);

        return distributorRepository.save(distributor);
    }

    @Override
    public Distributor update(Integer id,DistributorIn distributorIn) {
        Distributor distributor = distributorRepository.findById(id).orElse(null);
        distributorIn.setId(id);
        if (distributorIn.getProducts() == null){
            Collection<Product> products = distributor.getProducts();
            distributorIn.setProducts(products);

        }else {
            List<Product> products = (List<Product>) distributorIn.getProducts();

            for (int i = 0; i < products.size();i++){
                if (products.get(i).getName() == null){
                    Product product = productRepository.findById(products.get(i).getId()).orElse(null);
                    products.set(i,product);
                }
            }
            distributorIn.setProducts(products);
        }
        distributor = DistributorMapper.map(distributorIn);
        return distributorRepository.save(distributor);
    }

    @Override
    public void delete(Integer id,DistributorIn distributorIn) {
        Distributor distributor = distributorRepository.findById(id).orElse(null);
        distributor.setProducts(null);
        distributorRepository.save(distributor);
        distributorRepository.deleteById(id);
    }
}
