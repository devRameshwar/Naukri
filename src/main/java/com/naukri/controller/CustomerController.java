package com.naukri.controller;

import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetAllCustomerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public interface CustomerController extends Serializable {

    ResponseEntity<CreateCustomerResponse> create(@RequestBody CreateCustomerRequest request);

    ResponseEntity<List<GetAllCustomerRecord>> getAllCustomer();
}
