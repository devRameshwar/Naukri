package com.naukri.mapper;

import com.naukri.model.Customer;
import com.naukri.request.CreateCustomerRequest;
import com.naukri.responce.CreateCustomerResponse;
import com.naukri.responce.GetAllCustomerRecord;
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

    public Optional<List<GetAllCustomerRecord>> entityGetAllCustomer(List<Customer> customers) {

        List<GetAllCustomerRecord> customerRecords = modelMapper.
                map(customers, new TypeToken<List<GetAllCustomerRecord>>() {}.getType());
        return Optional.of(customerRecords);
    }
}
