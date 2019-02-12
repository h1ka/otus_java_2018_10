package ru.otus.ORM.dao;

public class TestUser {

    @Id
    private final long a;
    private final String a1;
    private final int a2;
    private final String a4;

    public TestUser(Long a, String a1, Integer a2, String a4) {
        this.a = a;
        this.a1 = a1;
        this.a2 = a2;
        this.a4 = a4;
    }

    public long getA() {
        return a;
    }

    public String getA1() {
        return a1;
    }

    public int getA2() {
        return a2;
    }

    public String getA4() {
        return a4;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "a=" + a +
                ", a1='" + a1 + '\'' +
                ", a2=" + a2 +
                ", a4='" + a4 + '\'' +
                '}';
    }
}
