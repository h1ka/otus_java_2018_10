package com.trap.MyTestFramework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class xUnit {


    public xUnit() {
    }

    public static void test(Class clazz) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = clazz.getDeclaredMethods();
        ArrayList<Method> publicMethods;
        ArrayList<Method> beforeTestMethods;
        ArrayList<Method> testMethods;
        ArrayList<Method> afterTestMethods;

        publicMethods = getPublicMethods(methods);
        beforeTestMethods = addMethodWithAnnotation(BeforeTest.class,publicMethods);
        testMethods = addMethodWithAnnotation(Test.class,publicMethods);
        afterTestMethods = addMethodWithAnnotation(AfterTest.class,publicMethods);

        for (Method testMethod : testMethods){
            Object  object = clazz.getConstructor().newInstance();
            try {
                callMethods(beforeTestMethods,object);
                testMethod.invoke(object);
                callMethods(afterTestMethods,object);
            }catch (Exception exp){
                System.err.println("Exception in test" + testMethod.toString());
            }
        }
    }

    private static void callMethods(ArrayList<Method> methods,Object object) throws InvocationTargetException, IllegalAccessException {
        for (Method method: methods) {
                method.invoke(object);
        }
    }
    private static ArrayList<Method> getPublicMethods(Method[] methods){
        ArrayList<Method> publicMethods = new ArrayList<Method>();
        for (Method method : methods) {
            if (method.getModifiers() != 1) {
                method.setAccessible(true); //Делаем как бы "public"
            }
            publicMethods.add(method);
        }
        return publicMethods;
    }
    private static ArrayList<Method> addMethodWithAnnotation(Class annotation, List<Method> methods) {
        ArrayList<Method> annotationsMethods = new ArrayList<Method>();
        for (Method method : methods) {
            if (method.getAnnotation(annotation) != null) {
                annotationsMethods.add(method);
            }
        }
        return annotationsMethods;
    }

}
