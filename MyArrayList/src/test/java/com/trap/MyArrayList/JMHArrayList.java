package com.trap.MyArrayList;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@State(value = Scope.Thread)
@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JMHArrayList {
    MyArrayList myArrayList ;
    long summ;
    ArrayList arrayList;
    long summA;
    final static int SIZE = 2_000_000;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(JMHArrayList.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }
    @Setup
    public void setup(){
        myArrayList = new MyArrayList(2000000);
        arrayList = new ArrayList(2000000);
    }

    @Benchmark
    public long addMyArrayTest(){
        for (int i = 0; i < SIZE; i++){
            summ+=i; myArrayList.add(i);
        }
        for (int i = 0; i < SIZE; i++){
             myArrayList.get(i);
        }
        return summ;
    }

    @Benchmark
    public long addArrayListTest(){
        for (int i =0; i < SIZE; i++){
            summA+=i; arrayList.add(i);
        }
        for (int i = 0; i < SIZE; i++){
              arrayList.get(i);
        }
        return summA;
    }

}
