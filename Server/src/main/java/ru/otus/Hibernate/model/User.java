package ru.otus.Hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private  long id;
    private  String name;
    private  int age;

    public User() {
    }
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phone;

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id + ", name="+name+", age=" + age +", "+ address + ", " + phone+"}";
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + ", name="+name+", age=" + age + "}";
    }
}
