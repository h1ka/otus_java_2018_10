package com.trap.Arr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {
    @Test
    public void test() {
        StackIntArray stackIntArray = new StackIntArray();
        stackIntArray.push(2);
        assertEquals(2,stackIntArray.pop());
    }

    @Test
    public void testNull(){
        try {
            StackIntArray stackIntArray = new StackIntArray();
            stackIntArray.pop();
        } catch (Exception e){
            assertEquals("array is empty",e.getMessage());
        }

    }

    @Test
    public void testAdd(){
        StackIntArray stackIntArray = new StackIntArray();
        stackIntArray.push(1);
        stackIntArray.push(2);
        stackIntArray.push(3);
        assertEquals(3,stackIntArray.pop());
        assertEquals(2,stackIntArray.pop());
        assertEquals(1,stackIntArray.pop());

    }
}
