package com.example.tacochallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tacochallenge.Customer;

@Controller    // This class is a Controller
@RequestMapping(path="/demo") // URL's start with /demo after Application path
public class MainController {
    @Autowired // Gets the bean called customerRepository

    private CustomerRepository customerRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewCustomer (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response
        // @RequestParam means it is a parameter from the GET or POST request

        Customer n = new Customer();
        n.setName(name);
        n.setEmail(email);
        customerRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Customer> getAllCustomers() {
        // This returns a JSON or XML with the customers
        return customerRepository.findAll();
    }
}
