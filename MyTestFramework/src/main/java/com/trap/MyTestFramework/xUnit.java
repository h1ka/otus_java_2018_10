package com.trap.MyTestFramework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class xUnit<T> {
    Class<T> clazz;



    public xUnit(Class clazz) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.clazz = clazz;
    }


    public void getAnnotation() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Object object =clazz.getConstructor().newInstance();
        System.out.println("--- annotations:");
        Method[] annotatedMethod = clazz.getDeclaredMethods();
        for (Method method : annotatedMethod) {
            if (method.getAnnotation(BeforeTest.class) != null) {
                method.invoke(object);
            }
        }
        for (Method method : annotatedMethod) {

            if (method.getAnnotation(Test.class) != null) {
                method.invoke(object);
            }
        }
        for (Method method : annotatedMethod) {
            if (method.getAnnotation(AfterTest.class) != null) {
                method.invoke(object);
            }
        }
    }
}
