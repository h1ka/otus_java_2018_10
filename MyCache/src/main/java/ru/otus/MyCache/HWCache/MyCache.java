package ru.otus.MyCache.HWCache;

import java.lang.ref.SoftReference;
import java.util.*;

public class MyCache<K, V> implements HwCache<K, V> {
//Надо реализовать эти методы

    private Map<K, SoftReference<V>> map = new HashMap<>();

    private Queue<HwListener<K,V>> listenerQueue = new ArrayDeque<>();


    public MyCache() {
    }


    @Override
    public V put(K key, V value) {
        SoftReference<V> softRef =
                map.put(key,  new SoftReference<>(value));

        for (var kvHwListener : listenerQueue) {
            HwListener<K,V> next = kvHwListener;
            next.notify(key, value, "put");
        }

        if (softRef==null)
            return null;

        V oldValue = softRef.get();

        return oldValue;
    }

    @Override
    public void remove(K key) {
        var value = map.get(key);
        for (var kvHwListener : listenerQueue) {
            HwListener<K,V> next =  kvHwListener;
            next.notify(key, value.get(), "remove");
        }
        map.remove ( key );
    }


    @Override
    public V get(K key) {
        SoftReference<V> softRef = map.get(key);
        if (softRef.get()==null){
            map.remove(key);
            return null;
        }

        return softRef.get();

    }

    @Override
    public void addListener(HwListener<K, V> listener) {
        listenerQueue.add(listener);

    }

    @Override
    public void removeListener(HwListener<K, V> listener) {
        listenerQueue.remove(listener);
    }

    @Override
    public int size() {
        return map.size();
    }

     Set keySet(){
        return map.keySet();
    }

}
