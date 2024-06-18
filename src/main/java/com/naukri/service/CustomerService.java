package com.naukri.service;

import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;

public interface CustomerService {

    CreateCustomerResponse create(CreateCustomerRequest request);
}
