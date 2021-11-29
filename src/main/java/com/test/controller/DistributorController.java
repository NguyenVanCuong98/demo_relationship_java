package com.test.controller;

import com.test.dto.DistributorDTO;
import com.test.entity.Distributor;
import com.test.entity.Product;
import com.test.in.DistributorIn;
import com.test.in.ProductIn;
import com.test.repository.DistributorRepository;
import com.test.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distributors")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistributorController {

    @Autowired
    private DistributorService distributorService;
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity<List<DistributorDTO>> getAll () {
        return new ResponseEntity<>(distributorService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Distributor> create (@RequestBody DistributorIn distributorIn) {
        return new ResponseEntity<>(distributorService.create(distributorIn), HttpStatus.OK);
    }
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Distributor> update (@PathVariable Integer id,@RequestBody DistributorIn distributorIn) {
        return new ResponseEntity<>(distributorService.update(id,distributorIn), HttpStatus.OK);
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public void delete (@PathVariable Integer id,@RequestBody DistributorIn distributorIn) {
        distributorService.delete(id,distributorIn);
    }
}
