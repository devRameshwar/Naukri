package com.naukri.controller.controllerImp;

import com.naukri.controller.CustomerController;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetAllCustomerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerControllerImp implements CustomerController {

    @Autowired


    @PostMapping
    public ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest request){

        return null;
    }

    @GetMapping
    public ResponseEntity<GetAllCustomerRecord> getAllCustomer(){

        return null;
    }
}
