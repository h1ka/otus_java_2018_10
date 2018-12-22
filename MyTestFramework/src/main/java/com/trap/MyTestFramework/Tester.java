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
    private void beforePrivate(){
        System.out.println("beforePrivate");
    }


    @Test
    public void testException() throws Exception {
        throw new Exception();
    }

    @Test
    public void testException2() throws Exception {
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
    public  void after(){
        System.out.println("after");
    }


}
