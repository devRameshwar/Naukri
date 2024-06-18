package com.naukri.dbHelper;

import com.naukri.model.Customer;
import com.naukri.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountDbHelperImp implements AccountDbHelper{

    @Autowired
    private CustomerRepository repository;

    @Override
    public Optional<Customer> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Customer> saveData(Customer customer) {
        return Optional.of(repository.save(customer));
    }

}
