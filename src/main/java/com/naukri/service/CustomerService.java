package com.naukri.service;

import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetCustomerRecord;

import java.util.List;

public interface CustomerService {

    CreateCustomerResponse create(CreateCustomerRequest request);

    List<GetCustomerRecord> getAllCustomer();

    GetCustomerRecord getCustomerById(String customerId);
}
