package com.barath.reactive.app;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    public Mono<Customer> saveCustomer(Customer customerMono){
       return Mono.justOrEmpty(customerRepository.save(customerMono)).log();
    }

    public Flux<Customer> getCustomers(){
        return Flux.fromIterable(customerRepository.findAll()).log();
    }
}
