package com.test.service.Mapper;

import com.test.dto.DistributorDTO;
import com.test.entity.Distributor;
import com.test.in.DistributorIn;
import org.springframework.stereotype.Component;

@Component
public class DistributorMapper {
    public static DistributorDTO map(Distributor distributor) {
        DistributorDTO distributorDTO = new DistributorDTO();
        distributorDTO.setId(distributor.getId());
        distributorDTO.setName(distributor.getName());
        distributorDTO.setAddress(distributor.getAddress());
        distributorDTO.setProducts(distributor.getProducts());
        return distributorDTO;
    }

    public static Distributor map(DistributorIn distributorIn) {
        Distributor distributor = new Distributor();
        if (distributorIn.getId() != null){
            distributor.setId(distributorIn.getId());
        }
        distributor.setName(distributorIn.getName());
        distributor.setAddress(distributorIn.getAddress());
        distributor.setProducts(distributorIn.getProducts());
        return distributor;
    }

}
