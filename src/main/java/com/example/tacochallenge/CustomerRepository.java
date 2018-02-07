package com.example.tacochallenge;

import org.springframework.data.repository.CrudRepository;

import com.example.tacochallenge.Customer;

// This will be AUTO IMPLEMENTED by Spring into a Bean called customerRepository
// CRUD refers Create, Read, Update, Delete

    public interface CustomerRepository extends CrudRepository<Customer, Long> {
        Customer findByEmail(String email);
        Customer findById(Integer id);
        Customer findByName(String name);
        Customer findByPhone(String phone);

}