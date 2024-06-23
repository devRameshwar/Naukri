package com.naukri.repository;

import com.naukri.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    @Query(value = "SELECT * FROM Customer ",nativeQuery = true)
    Optional<List<Customer>> findAllCustomer();
}
