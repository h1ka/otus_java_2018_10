package ru.otus.MyCache.HWCache;

public interface HwCache<K, V> {

    V put(K key, V value);

    void remove(K key);

    V get(K key);

    void addListener(HwListener listener);

    void removeListener(HwListener listener);

    int size();
}
