package ru.otus.ORM.dao;

public class User {

    @Id
    private final long id;
    private final String name;
    private final int age;


    public User(Long id, String name, Integer age) {

        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
