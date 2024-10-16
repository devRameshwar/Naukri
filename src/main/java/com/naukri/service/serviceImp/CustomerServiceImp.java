package com.naukri.service.serviceImp;

import com.naukri.constant.ApplicationConstant;
import com.naukri.dbHelper.AccountDbHelper;
import com.naukri.exception.SomethingWentWrongException;
import com.naukri.exception.UserAlreadyExists;
import com.naukri.exception.UserNotFoundException;
import com.naukri.mapper.CustomerMapper;
import com.naukri.model.Customer;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetCustomerRecord;
import com.naukri.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.naukri.constant.ApplicationConstant.SOMETHING_WENT_WRONG;

@Service
public class CustomerServiceImp implements CustomerService {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImp.class);
    @Autowired
    private AccountDbHelper dbHelper;
    @Autowired
    private CustomerMapper mapper;

    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {

        if(dbHelper.findByEmail(request.getEmail()).isPresent()){
            throw new UserAlreadyExists(ApplicationConstant.USER_ALREADY_EXITS);
        }

        Customer customer = mapper.requestToEntity(request).orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));

        Customer saved = dbHelper.saveData(customer).orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));

        return mapper.entityToResponce(saved).orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));

    }

    @Override
    public GetCustomerRecord findByEmail(String email) {
        LOGGER.info("****** getting data in service findByEmail: "+email);
        return null;
    }

    @Override
    public GetCustomerRecord findByMobileNumber(String mobileNumber) {
        LOGGER.info("****** getting data in service findByMobileNumber: "+mobileNumber);
        return null;
    }

    @Override
    public GetCustomerRecord findByEmailOrMobileNumber(String email, String mobileNumber) {
        LOGGER.info("****** getting data in service findByEmailOrMobileNumber: "+email+"\t"+mobileNumber);
        return null;
    }

    @Override
    public GetCustomerRecord getCustomerById(String customerId) {
        Customer customer = dbHelper.findByCostomerid(customerId).orElseThrow(() -> new UserNotFoundException(ApplicationConstant.USER_NOT_FOUND));
        LOGGER.info("*********Getting Data By Id: " + customer);
        GetCustomerRecord getCustomerRecord = mapper.entityToResponceById(customer).orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));
        return getCustomerRecord;
    }

    @Override
    public List<GetCustomerRecord> getAllCustomer() {
        List<Customer> customers = dbHelper.getAllCustomer().orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));
        List<GetCustomerRecord> getCustomerRecords = mapper.entityGetAllCustomer(customers).orElseThrow(() -> new SomethingWentWrongException(SOMETHING_WENT_WRONG));
        return getCustomerRecords;
    }
}
