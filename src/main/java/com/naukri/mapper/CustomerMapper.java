package com.naukri.mapper;

import com.naukri.model.Customer;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetCustomerRecord;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;


    public Optional<Customer> requestToEntity(CreateCustomerRequest request) {
        return Optional.ofNullable(modelMapper.map(request, Customer.class));
    }

    public Optional<CreateCustomerResponse> entityToResponce(Customer saved) {
        return Optional.ofNullable(modelMapper.map(saved, CreateCustomerResponse.class));
    }

    public Optional<List<GetCustomerRecord>> entityGetAllCustomer(List<Customer> customers) {

        List<GetCustomerRecord> customerRecords = modelMapper.
                map(customers, new TypeToken<List<GetCustomerRecord>>() {}.getType());
        return Optional.of(customerRecords);
    }


    public Optional<GetCustomerRecord> entityToResponceById(Customer customer) {
        return Optional.ofNullable(modelMapper.map(customer, GetCustomerRecord.class));
    }
}
