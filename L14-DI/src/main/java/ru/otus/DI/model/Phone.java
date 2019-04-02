package ru.otus.DI.model;

import javax.persistence.*;

@Entity
public class Phone {
    @Column(name = "phone_number", nullable = false)
    private String number;


    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;

    public Phone() {
    }

    public Phone(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}