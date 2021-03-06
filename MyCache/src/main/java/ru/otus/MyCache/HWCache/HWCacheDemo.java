package ru.otus.MyCache.HWCache;


public class HWCacheDemo {

    public static void main(String[] args) {
        new HWCacheDemo().demo();
    }

    private void demo() {
        final int SIZE_FILL_CACHE=10000;
        HwCache<Integer, Integer> cache = new MyCache<>();
        HwListener<Integer, Integer> listener =
                (key, value, action) -> System.out.println("key:" + key + ", value:" + value + ", action:" + action);
        cache.addListener(listener);
        cache.put(1,1);
        System.out.println(cache.get(1));
        cache.remove(1);
        cache.removeListener(listener);
        HwCache<Long, BigObject> bigCache = new MyCache<>();
        HwListener<Long, BigObject> bigListener =
                (key, value, action) -> System.out.println("key:" + key + ", value:" + value + ", action:" + action);
        bigCache.addListener(bigListener);
        for (long i = 0; i<SIZE_FILL_CACHE;i++){
            bigCache.put(i, new BigObject());
        }
        int sum=0;

        for (long i = 0; i<SIZE_FILL_CACHE;i++){
            BigObject bigObject = bigCache.get(i);
            if (bigObject!=null) {
                System.out.println(i+ " value = " + bigObject);
                sum++;
            }
        }
        System.out.println(((MyCache<Integer, Integer>) cache).keySet());
        System.out.println(bigCache.size());
        System.out.println(((MyCache<Long, BigObject>) bigCache).keySet());
        System.out.println("put = "+ SIZE_FILL_CACHE + " get = "+ sum );
    }
}
