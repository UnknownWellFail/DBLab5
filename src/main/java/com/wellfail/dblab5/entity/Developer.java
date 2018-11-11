package com.wellfail.dblab5.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Developer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name can't be empty")
    private String name;

    @NotBlank(message = "Last name can't be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Middle name can't be empty")
    @Column(name = "middle_name")
    private String middleName;

    @Email
    @NotBlank(message = "Email can't be empty")
    private String email;

    @NotBlank(message = "Phone can't be empty")
    @Column(name = "phone")
    private String phoneNumber;


    @OneToMany(mappedBy = "developer", cascade = CascadeType.ALL)
    private Set<Orders> orders;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "profiles",
            joinColumns = {@JoinColumn(name = "developer_id")},
            inverseJoinColumns = {@JoinColumn(name = "profile_id")
            })
    private Set<Profile> profiles = new HashSet<>();

    public Developer() {
    }

    public Developer(String name, String lastName, String middleName, String email, String phoneNumber, Set<Profile> profiles) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profiles = profiles;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
