package ru.otus.MyCache.HWCache;

import java.lang.ref.SoftReference;
import java.util.*;

public class MyCache<K, V> implements HwCache<K, V> {
//Надо реализовать эти методы

    private Map<K, SoftReference<V>> map = new HashMap<>();

    private Queue<HwListener<K,V>> listenerQueue = new ArrayDeque<>();

    private Queue<K> queueKeys = new PriorityQueue<>();


    public MyCache() {
    }

    private void deleteKeysWithNullValue(){
        while (queueKeys.size()!=0) {
            if (map.size() < 2) return;

            queueKeys.remove(0);
            K oldKey = queueKeys.peek();
            if (map.get(oldKey).get() != null) return;

            map.remove(oldKey);
            for (var kvHwListener : listenerQueue) {
                HwListener next = kvHwListener;
                next.notify(oldKey, "valueIsNull", "clearCache");
            }

            queueKeys.remove(oldKey);
        }
    }

    @Override
    public V put(K key, V value) {
        this.deleteKeysWithNullValue();
        SoftReference<V> softRef =
                map.put(key,  new SoftReference<>(value));
        queueKeys.add(key);

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
        SoftReference value = map.get(key);
        for (var kvHwListener : listenerQueue) {
            HwListener next =  kvHwListener;
            next.notify(key, value.get(), "remove");
        }
        map.remove ( key );
        queueKeys.remove(key);
    }


    @Override
    public V get(K key) {
        this.deleteKeysWithNullValue();
        SoftReference<V> softRef = map.get(key);
        if (softRef==null)
            return null;

        return softRef.get();

    }

    @Override
    public void addListener(HwListener listener) {
        listenerQueue.add(listener);

    }

    @Override
    public void removeListener(HwListener listener) {
        listenerQueue.remove(listener);
    }

    @Override
    public int size() {
        return map.size();
    }

    public Set keySet(){
        return map.keySet();
    }

}
