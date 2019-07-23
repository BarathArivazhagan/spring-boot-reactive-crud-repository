package com.barath.reactive.app;

import java.lang.invoke.MethodHandles;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }


    public Mono<Customer> saveCustomer(Customer customer){
       return Mono.justOrEmpty(customerRepository.save(customer)).log();
    }

    public Flux<Customer> saveCustomers(List<Customer> customers){
        return Flux.fromIterable(customers).doOnNext( customer -> {
            logger.info("creating customer with details {}",customer);
            customerRepository.save(customer);
        }).doOnError( throwable -> {
            logger.error("Error in creating customer {}",throwable);
        }).log();
    }

    public Mono<Void> deleteCustomerByName(String customerName){

        return Mono.justOrEmpty(customerName).doOnNext( customer -> {
            logger.info("deleting customer with details {}",customer);
            customerRepository.delete(customerRepository.findByCustomerName(customerName));
        }).then(Mono.empty());
    }

    public Flux<Customer> getCustomers(){
        return Flux.fromIterable(customerRepository.findAll()).log();
    }
}
