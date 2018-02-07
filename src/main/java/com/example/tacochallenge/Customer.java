package com.example.tacochallenge;

import org.hibernate.mapping.Set;

import javax.persistence.*;

@Entity // Tells Hibernate to make a table out of this class
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @EmbeddedId
    private CustomerId customerId;


    private Integer id;

    private String name;

    private String email;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() { return phone;}

    public void setPhone(String phone) {this.phone = phone; }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Customer() {
    }


}