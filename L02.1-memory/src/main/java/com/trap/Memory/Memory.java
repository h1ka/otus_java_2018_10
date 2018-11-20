package com.trap.Memory;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * VM options -Xmx512m -Xms512m
 * -XX:+UseCompressedOops //on
 * -XX:-UseCompressedOops //off
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Memory {


    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());
        System.out.println("Starting the loop");
        System.out.println(Factory.measureByte());
        System.out.println(Factory.measureShort());
        System.out.println(Factory.measureInt());
        System.out.println(Factory.measureLong());
        System.out.println(Factory.measureBoolean());
        System.out.println(Factory.measureChar());
        System.out.println(Factory.measureFloat());
        System.out.println(Factory.measureDouble());

        new Factory<>(()-> new String(new char[0])); //String::new ; Byte.class ; Integer.class
        new Factory<>(Integer.class);
        new Factory<>(Boolean.class);
        new Factory<>(ArrayList::new);
        new Factory<>(ArrayList::new,10);
        new Factory<>(HashMap::new);
        new Factory<>(MyClass::new);
    }

    private static class MyClass {
        private byte b = 0;     // +1
        private int i = 0;      // +4
        private long l = 1;     // +8
    }
}
