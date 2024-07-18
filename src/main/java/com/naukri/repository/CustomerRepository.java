package com.naukri.repository;

import com.naukri.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM Customer WHERE EMAIL=:email",nativeQuery = true)
    Optional<Customer> findCustomerByEmail(@Param("email") String email );

    @Query(value = "SELECT * FROM Customer ",nativeQuery = true)
    Optional<List<Customer>> findAllCustomer();

    @Query(value = "SELECT * FROM Customer WHERE customer_id=?",nativeQuery = true)
    Optional<Customer> findByCustomerId(String customer_id);
}
