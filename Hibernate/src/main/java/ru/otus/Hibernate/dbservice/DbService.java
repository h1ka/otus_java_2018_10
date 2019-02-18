package ru.otus.Hibernate.dbservice;

public interface DbService<T> {
    void save(T objectData);
    <T> T load(long id, Class<T> clazz);
}