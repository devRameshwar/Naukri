package com.naukri.repository;

import com.naukri.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {


    Optional<Customer> findByEmail(String email);
}
