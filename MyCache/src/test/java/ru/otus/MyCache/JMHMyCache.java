package ru.otus.MyCache;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.otus.MyCache.HWCache.MyCache;

import java.util.concurrent.TimeUnit;

@State(value = Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHMyCache {
    private int cacheSize = 200_000;
    private MyCache<Integer,Integer> myCache;
    static int summPut;
    static int summGet;
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHMyCache.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }
    @Setup
    public void setuo(){
        myCache = new MyCache();
    }

    @Benchmark
    public long myCacheTest() {

        Thread myPut = new Thread() {

            @Override
            public void run() {
                for (int i = 0; i < cacheSize; i++) {
                    myCache.put(i, i);
                    summPut++;
                }
            }
        };
        myPut.start();
        myPut.start();
        myPut.start();
        return summPut;
    }

        @Benchmark
        public long myCacheGetTest(){
        Thread myFet = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < cacheSize; i++){
                     summGet+=myCache.get(i);
                }
            }
        };
        myFet.start();
        myFet.start();
        return summGet;
    }
}
