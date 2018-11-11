package com.wellfail.dblab5.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Orders implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "client_id")

    private Client orderClient;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @JoinColumn(name = "order_id")
     private Order order;

    public Orders() {
    }

    public Orders(Date date, Client orderClient, Developer developer, Order order) {
        this.date = date;
        this.orderClient = orderClient;
        this.developer = developer;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getOrderClient() {
        return orderClient;
    }

    public void setOrderClient(Client orderClient) {
        this.orderClient = orderClient;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
