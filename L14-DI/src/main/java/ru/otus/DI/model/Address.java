package ru.otus.DI.model;

import javax.persistence.*;

@Entity
public class Address {
    @Column(name = "street", nullable = false)
    private String street;


    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User user;

    public Address() {
    }

    public Address(String street, User user) {
        this.street = street;
        this.user = user;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                '}';
    }
}
