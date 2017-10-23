package com.barath.reactive.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
