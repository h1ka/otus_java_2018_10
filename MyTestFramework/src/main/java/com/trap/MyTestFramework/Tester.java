package com.trap.MyTestFramework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Tester {

    public Tester(){

    }

    @BeforeTest
    public static void before(){
        System.out.println("before");
    }


    @BeforeTest
    public static void before1(){
        System.out.println("before1");
    }

    @BeforeTest
    public static void before3(){
        System.out.println("before3");
    }

    @BeforeTest
    public static void before2(){
        System.out.println("before2");
    }


    @Test
    public static void testFirst(){
        System.out.println("test1");
    }

    @Test
    public static void testTwo(){
        System.out.println("test2");
    }


    @AfterTest
    public static void after(){
        System.out.println("after");
    }
}
