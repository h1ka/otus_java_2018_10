package ru.otus.ATM.Version2;

public interface Box {
    void add(int count);
    int getCount();
    boolean isGet(int count);
    void removeFromBox(int count);
}
