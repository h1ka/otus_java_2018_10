package com.trap.Memory;

import java.lang.management.ManagementFactory;

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
        int size = 20_000_000;
        while (true) {
            long mem = getMem();
            System.out.println("Mem: " + mem);

            Factory<?> factory = new Factory<>(MyClass::new); //String::new ; Byte.class ; Integer.class
            var array = factory.createMas(size);
            long mem2 = getMem();
            System.out.println("Ref size: " + (mem2 - mem) / array.length);

            for (int i = 0; i < array.length; i++) {
                array[i] = new MyClass();
            }

            long mem3 = getMem();
            System.out.println("Element size: " + (mem3 - mem2) / array.length);

            array = null;
            System.out.println("Array is ready for GC");

            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static class MyClass {
        private byte b = 0;     // +1
        private int i = 0;      // +4
        private long l = 1;     // +8
    }
}
