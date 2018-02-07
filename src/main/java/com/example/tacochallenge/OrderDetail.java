package com.example.tacochallenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {

    @Id
    @Column(name="order_id")
    private String orderId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "phone", referencedColumnName = "phone"),
            @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    })
    private Customer customer;

    private String history;

    public OrderDetail(){
    }

    public OrderDetail(String orderId, String history, Customer customer){
        this.orderId = orderId;
        this.history = history;
        this.customer = customer;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public void setHistoryName(String product){
        this.history = history;
    }

    public String getHistory(){
        return this.history;
    }

    public String toString(){
        return String.format("['history': %s]", this.history);
    }


}