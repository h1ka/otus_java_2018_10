package com.trap.Memory;

import java.lang.reflect.Array;
import java.util.function.Supplier;

public class Factory<T>{

    Supplier<?> supplier;
    private Class TClass;

    public Factory(Class<T> tClass){
        TClass = tClass;
        System.out.println("Class " + TClass);
    }

    public Factory(Supplier supplier){
        this.supplier = supplier;
        TClass = supplier.get().getClass();
        System.out.println(TClass);
    }

    public Factory (int i){

    }
    public T[] createMas(int size){
        T[] mas;
        mas = (T[]) Array.newInstance(TClass, size);
        return mas;
    }


}
