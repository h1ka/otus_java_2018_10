package ru.otus.MyCache.HWCache;

public interface HwListener<K, V> {
    void notify(K key, V value, String action);
}
