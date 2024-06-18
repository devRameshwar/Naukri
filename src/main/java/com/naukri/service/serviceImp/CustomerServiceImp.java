package com.naukri.service.serviceImp;

import com.naukri.constant.ApplicationConstant;
import com.naukri.dbHelper.AccountDbHelper;
import com.naukri.exception.SomethingWentWrongException;
import com.naukri.exception.UserAlreadyExists;
import com.naukri.mapper.CustomerMapper;
import com.naukri.model.Customer;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private AccountDbHelper dbHelper;
    @Autowired
    private CustomerMapper mapper;

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        dbHelper.findByEmail(request.getEmail()).orElseThrow(() -> new UserAlreadyExists(ApplicationConstant.USER_ALREADY_EXITS));

        Customer customer = mapper.requestToEntity(request).orElseThrow(() -> new SomethingWentWrongException(ApplicationConstant.SOMETHING_WENT_WRONG));

        Customer saved = dbHelper.saveData(customer).orElseThrow(() -> new SomethingWentWrongException(ApplicationConstant.SOMETHING_WENT_WRONG));

        return mapper.entityToResponce(saved).orElseThrow(() -> new SomethingWentWrongException(ApplicationConstant.SOMETHING_WENT_WRONG));

    }
}
