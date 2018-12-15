package com.trap.MyTestFramework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class xUnit {

    private static  Object object;

    private xUnit(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      Object  object = clazz.getConstructor().newInstance();
    }
    public static void test(Class clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        xUnit xUnit = new xUnit(clazz);
        Method[] annotatedMethod = clazz.getDeclaredMethods();
    }
    public static void ontest(Class clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        System.out.println("--- annotations:");
        Method[] annotatedMethod = clazz.getDeclaredMethods();
        ArrayList<Method> publicMethod = new ArrayList<Method>();
        int size = annotatedMethod.length;
        System.out.println("size = "+ size);
        for (Method method : annotatedMethod){
            if (method.getModifiers()==1){
                publicMethod.add(method);
            }
        }
        for (Method method : publicMethod) {
            if (method.getAnnotation(BeforeTest.class) != null) {
                method.invoke(object);
            }
        }
        for (Method method : publicMethod) {

            if (method.getAnnotation(Test.class) != null) {
                method.invoke(object);
            }
        }
        for (Method method : publicMethod) {
            if (method.getAnnotation(AfterTest.class) != null) {
                method.invoke(object);
            }
        }
    }
}
