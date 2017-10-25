package com.barath.reactive.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

        Customer findByCustomerName(String customerName);
}
