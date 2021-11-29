package com.test.service;

import com.test.dto.DistributorDTO;
import com.test.entity.Distributor;
import com.test.entity.Product;
import com.test.in.DistributorIn;
import com.test.in.ProductIn;

import java.util.List;

public interface DistributorService {
    List<DistributorDTO> getAll();
    Distributor create(DistributorIn productIn);
    Distributor update(Integer id,DistributorIn productIn);
    void delete(Integer id,DistributorIn productIn);
}
