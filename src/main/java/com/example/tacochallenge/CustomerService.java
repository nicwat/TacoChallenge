package com.example.tacochallenge;

import com.example.tacochallenge.Customer;
import com.example.tacochallenge.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CustomerService  {

    @Autowired
    private CustomerRepository repository;

    public Boolean update(Customer customer ) {
        Customer existingCustomer = repository.findByName(customer.getName());
        if (existingCustomer == null)
            return false;

        // name updatable
        existingCustomer.setName(customer.getName());
            existingCustomer.setName(customer.getName());


        Customer saved = repository.save(existingCustomer);
        if (saved == null)
            return false;

        return true;
    }



}