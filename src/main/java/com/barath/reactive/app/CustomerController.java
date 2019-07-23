package com.barath.reactive.app;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }


    @PostMapping(value = "/customer")
    public Mono<Customer> createCustomer(@RequestBody Customer customer){

        return customerService.saveCustomer(customer);

    }

    @GetMapping(value = "/customers")
    public Flux<Customer> getCustomers(){
        return customerService.getCustomers();
    }
}
