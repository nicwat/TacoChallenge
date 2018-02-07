package com.example.tacochallenge;

import org.hibernate.mapping.Set;

import javax.persistence.*;

@Entity // Tells Hibernate to make a table out of this class
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @EmbeddedId
    private CustomerId customerId;

//    private Integer id;
    private String name;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Customer(){}

    public Customer(CustomerId customerId, String name, String email, String phone){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Customer(CustomerId customerId, String name, String email, String phone, Set<OrderDetail> orderDetails){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orderDetails= orderDetails;
    }

//    public Integer getId() {
//        return id;
//    }
    public void setCustomerId(CustomerId customerId){
        this.customerId = customerId;
    }

    public CustomerId getCustomerId(){
        return this.customerId;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails){
        this.orderDetails = orderDetails;
    }

    public Set<OrderDetail> getOrderDetails(){
        return this.orderDetails;
    }


}