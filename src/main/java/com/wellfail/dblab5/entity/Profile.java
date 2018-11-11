package com.wellfail.dblab5.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "profiles",
            joinColumns = {@JoinColumn(name = "profile_id ")},
            inverseJoinColumns = {@JoinColumn(name = "developer_id")
            })
    private Set<Developer> developers = new HashSet<>();

    public Profile() {
    }

    public Profile(String name, String description) {
        this.name = name;
        this.description = description;
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
