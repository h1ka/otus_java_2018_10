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

    public xUnit() {
    }

    public static void test(Class clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object  object = clazz.getConstructor().newInstance();
        testDo(clazz,object);
    }

    public static void testDo(Class clazz,Object object) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = clazz.getDeclaredMethods();
        ArrayList<Method> publicMethod = new ArrayList<Method>();
        int size = methods.length;
        System.out.println("size = "+ size);
        for (Method method : methods){
            if (method.getModifiers()!=1){
                method.setAccessible(true); //Делаем как бы "public"
            }
            publicMethod.add(method);
        }

    try {
        for (Method method : publicMethod) {
            if (method.getAnnotation(BeforeTest.class) != null) {
                method.invoke(object);
            }
        }
    } catch (Exception exp){
        exp.printStackTrace();
    }

       try {
           for (Method method : publicMethod) {

               if (method.getAnnotation(Test.class) != null) {
                   method.invoke(object);
               }
           }
       }catch (Exception exp){
           exp.printStackTrace();
       }

        try {
            for (Method method : publicMethod) {
                if (method.getAnnotation(AfterTest.class) != null) {
                    method.invoke(object);
                }
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }
}
