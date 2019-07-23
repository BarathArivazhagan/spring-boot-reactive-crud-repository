package com.barath.reactive.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

        Customer findByCustomerName(String customerName);
}
