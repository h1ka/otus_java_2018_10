package com.trap.MyTestFramework;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Tester {

    public Tester(){

    }

    @BeforeTest
    public  void before(){
        System.out.println("before");
    }


    @BeforeTest
    public  void before1(){
        System.out.println("before1");
    }

    @BeforeTest
    private void beforePrivate(){
        System.out.println("beforePrivate");
    }

    @BeforeTest
    public  void beforeException() throws Exception {
        System.out.println("beforeException");
        throw new Exception();
    }


    @Test
    public  void testFirst(){
        System.out.println("test1");
    }

    @Test
    public  void testTwo(){
        System.out.println("test2");
    }

    @AfterTest
    public  void afterException() throws Exception {
        System.out.println("afterException");
        throw new Exception();

    }
    @AfterTest
    public  void after(){
        System.out.println("after");
    }


}
