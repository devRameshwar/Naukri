package com.naukri.controller.controllerImp;

import com.naukri.controller.CustomerController;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetAllCustomerRecord;
import com.naukri.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerControllerImp implements CustomerController {

    @Autowired
    private CustomerService service;
    Logger logger= LoggerFactory.getLogger(CustomerControllerImp.class);


    @PostMapping
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest request){
        logger.info("request: "+request);
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public ResponseEntity<GetAllCustomerRecord> getAllCustomer(){

        return null;
    }
}
