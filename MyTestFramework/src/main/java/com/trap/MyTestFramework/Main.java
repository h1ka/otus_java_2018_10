package com.trap.MyTestFramework;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
       String a = "1";
        System.out.println(a.equals("2") ? a : "null");
        xUnit.test(Tester.class);
    }

}
