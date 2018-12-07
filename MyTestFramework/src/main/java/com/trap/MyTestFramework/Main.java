package com.trap.MyTestFramework;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        xUnit tester = new xUnit(Tester.class);
        tester.getAnnotation();
    }
}
