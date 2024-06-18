package com.naukri.dbHelper;

import com.naukri.model.Customer;

import java.util.Optional;

public interface AccountDbHelper {


    Optional<Customer> findByEmail(String email);

    Optional<Customer> saveData(Customer customer);
}
