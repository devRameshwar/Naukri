package com.naukri.controller.controllerImp;

import com.naukri.controller.CustomerController;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetCustomerRecord;
import com.naukri.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerControllerImp implements CustomerController {

    @Autowired
    private CustomerService service;
   private final Logger LOGGER= LoggerFactory.getLogger(CustomerControllerImp.class);


    @Override
    @PostMapping
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest request){
        LOGGER.info("*********request: "+request);
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<GetCustomerRecord>>getAllCustomer(){
        return ResponseEntity.ok(service.getAllCustomer());
    }

    //get user by CustomerId
    @Override
    @GetMapping(path = "/customerId/{customerId}")
    public ResponseEntity<GetCustomerRecord> getCustomerRecordById(@PathVariable String customerId ){
        LOGGER.info("*********** Customer id: "+customerId);
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }
}
