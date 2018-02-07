package com.example.tacochallenge;

import java.util.Set;

import org.hibernate.mapping.Set;
import javax.persistence.*;


import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity // Tells Hibernate to make a table out of this class
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @EmbeddedId
    private CustomerId customerId;

//    private Integer id;
    private String name;
    private String email;
//    private String phone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Customer(){}

    public Customer(CustomerId customerId, String name, String email,){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public Customer(CustomerId customerId, String name, String email, String phone, Set<OrderDetail> orderDetails){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
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

//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getPhone() {
//        return phone;
//    }

    public void setOrderDetails(Set<OrderDetail> orderDetails){
        this.orderDetails = orderDetails;
    }

    public Set<OrderDetail> getOrderDetails(){
        return this.orderDetails;
    }

    public String toString(){
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("customerId",this.customerId.getCustomerId());
        jsonInfo.put("phone", this.customerId.getPhone());
        jsonInfo.put("name", this.getName());
        jsonInfo.put("email", this.getEmail());

        JSONArray orders = new JSONArray();
        if(this.orderDetails != null){
            this.orderDetails.forEach(order->{
                JSONObject orderInfo = new JSONObject();
                orderInfo.put("orderId-" + order.getOrderId() , order);
                orders.put(orderInfo);
            });
        }
        jsonInfo.put("history", orders);
        info = jsonInfo.toString();
        return info;

    }


}