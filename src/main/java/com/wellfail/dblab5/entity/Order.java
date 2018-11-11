package com.wellfail.dblab5.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderr")
public class Order implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @OneToOne(mappedBy = "order")
    private Orders orders;


    public Order() {
    }

    public Order(String name, String description/*, boolean status*/) {
        this.name = name;
        this.description = description;
        //    this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
