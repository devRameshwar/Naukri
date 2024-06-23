package com.naukri.dbHelper;

import com.naukri.model.Customer;
import com.naukri.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AccountDbHelperImp implements AccountDbHelper{

    @Autowired
    private CustomerRepository repository;

    Logger logger= LoggerFactory.getLogger(AccountDbHelperImp.class);

    @Override
    public Optional<Customer> findByEmail(String email) {
        logger.info("Account db helper data: "+email);
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Customer> saveData(Customer customer) {
        return Optional.of(repository.save(customer));
    }

    @Override
    public Optional<List<Customer>> getAllCustomer() {
        return repository.findAllCustomer();
    }
}
