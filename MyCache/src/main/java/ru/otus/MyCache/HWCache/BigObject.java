package ru.otus.MyCache.HWCache;


public class BigObject {
    final byte[] array = new byte[1024 * 1024];
    public byte[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "BigObject";
    }
}
