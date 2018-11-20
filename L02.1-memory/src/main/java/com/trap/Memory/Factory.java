package com.trap.Memory;

import java.lang.reflect.Array;
import java.util.Random;
import java.util.function.Supplier;

public class Factory<T>{

    private static final int SIZE = 20_000_00;
    private Class TClass;

    static long measureByte()  {
        long mem1 = getMem();
        byte[] array = new byte[SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = (byte)i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("byte size: " + size + " len:" + array.length);
        return size;
    }

    static long measureInt()  {
        long mem1 = getMem();
        int[] array = new int[SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("int size: " + size + " len:" + array.length);
        return size;
    }

    static long measureShort()  {
        long mem1 = getMem();
        short[] array = new short[SIZE];

        for (int i = 0; i < array.length; i++) {
            array[i] = (short)i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("short size: " + size + " len:" + array.length);
        return size;
    }

    static long measureLong()  {
        long mem1 = getMem();
        long[] array = new long[SIZE];
        System.out.println("after array:" + getMem());

        for (int i = 0; i < array.length; i++) {
            array[i] = (long)i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("long size: " + size + " len:" + array.length);
        return size;
    }

    static long measureChar()  {
        long mem1 = getMem();
        char[] array = new char[SIZE];
        System.out.println("after array:" + getMem());

        for (int i = 0; i < array.length; i++) {
            array[i] = (char)i;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("char size: " + size + " len:" + array.length);
        return size;
    }
    static long measureDouble()  {
        long mem1 = getMem();
        double[] array = new double[SIZE];
        System.out.println("after array:" + getMem());

        for (int i = 0; i < array.length; i++) {
            array[i] = i*1d;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("double size: " + size + " len:" + array.length);
        return size;
    }
    static long measureFloat()  {
        long mem1 = getMem();
        float[] array = new float[SIZE];
        System.out.println("after array:" + getMem());

        for (int i = 0; i < array.length; i++) {
            array[i] = i*1f;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("float size: " + size + " len:" + array.length);
        return size;
    }
    static long measureBoolean()  {
        long mem1 = getMem();
        boolean[] array = new boolean[SIZE];
        System.out.println("after array:" + getMem());

        for (int i = 0; i < array.length; i=i+2) {
            array[i] = true;
        }
        for (int i = 1; i < array.length; i=i+2){
            array[i] = false;
        }

        long size = (getMem() - mem1) / array.length;
        System.out.println("boolean size: " + size + " len:" + array.length);
        return size;
    }

    public Factory(Class<T> tClass){
        long mem1 = getMem();
        TClass = tClass;
        System.out.println("Class " + TClass);
        T[] array = (T[]) Array.newInstance(TClass, SIZE);
        if (array[0] instanceof Integer) {
            Integer[] integer = (Integer[]) array;
            for (int i = 0;i<array.length;i++){
                integer[i] = new Integer(i);
            }
        } else {
            if (array[0] instanceof Boolean) {
                Boolean[] booleans = (Boolean[]) array;
                for (int i = 0; i < array.length; i=i+2) {
                    booleans[i] =new Boolean(true);
                }
                for (int i = 1; i < array.length; i=i+2){
                    booleans[i] = new Boolean(false);
                }
            }
        }
        long size = (getMem() - mem1) / array.length;
        System.out.println("Element size: " + size + " len:" + array.length);
        System.out.println(TClass.getName() + " " + size);
        System.out.println();
    }

    public Factory(Supplier<T> supplier){
        TClass = supplier.get().getClass();
        System.out.println(TClass);
        T[] array = (T[]) Array.newInstance(TClass, SIZE);
        long mem1 = getMem();
        for (int i = 0;i<array.length;i++){
            array[i] =supplier.get();
        }
        long size = (getMem() - mem1) / array.length;
        System.out.println("Element size: " + size + " len:" + array.length);
        System.out.println(TClass.getName() + " " + size);
        System.out.println();
    }
    public Factory(Supplier<T> supplier,int sizeArray){
        TClass = supplier.get().getClass();
        System.out.println(TClass);
        T[] array = (T[]) Array.newInstance(TClass, sizeArray);
        long mem1 = getMem();
        for (int i = 0;i<array.length;i++){
            array[i] =supplier.get();
        }
        long size = (getMem() - mem1) / array.length;
        System.out.println("Element size: " + size + " len:" + array.length);
        System.out.println(TClass.getName() + " " + size);
        System.out.println();
    }



    private static long getMem() {
        System.gc();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }


}
