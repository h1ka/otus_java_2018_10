package com.trap.MyArrayList;

import com.trap.MyArrayList.types.MyArrayListV;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

public class MyArrayListTest {

    @Test(expected = RuntimeException.class)
    public void setBYIndexMoreSize(){
        List<String> myArrayList = new MyArrayListV<>();
        myArrayList.add("value");
        myArrayList.set(3,"value2");
    }
    @Test(expected = RuntimeException.class)
    public void getByIndexMoreSize(){
        List<String> myArrayList = new MyArrayListV<>();
        myArrayList.add("value1");
        myArrayList.get(3);

    }
    @Test
    public void listIterator() throws Exception {
        List<String> myArrayList = new MyArrayListV<>(2);
        final String value1 = "1";
        final String value2 = "2";
        final String value3 = "3";

        myArrayList.add(value1);
        myArrayList.add(value2);
        myArrayList.add(value3);
        ListIterator<String> iterator = myArrayList.listIterator();
        assertTrue(iterator.hasNext());
        assertTrue(value1.equals(iterator.next()));
        assertTrue(value2.equals(iterator.next()));
        assertTrue(value3.equals(iterator.next()));
        assertFalse(iterator.hasNext());

    }
    @Test
    public void iterator(){
        List<Integer> myArrayList = new MyArrayListV<>(2);
        final int value1 = 1;
        final int value2 = 2;
        final int value3 = 3;

        myArrayList.add(value1);
        myArrayList.add(value2);
        myArrayList.add(value3);
        Iterator<Integer> iterator = myArrayList.iterator();
        assertTrue(iterator.hasNext());
        assertTrue(value1==iterator.next());
        assertTrue(value2==iterator.next());
        assertTrue(value3==iterator.next());
        assertFalse(iterator.hasNext());

    }
    @Test
    public void add() throws Exception {
        List<String> myArrayList = new MyArrayListV<>(2);

        assertEquals("size_0", 0, myArrayList.size() );

        boolean result = myArrayList.add("test1");
        assertTrue("changed", result);
        assertEquals("size_1", 1, myArrayList.size() );

        result = myArrayList.add("test2");
        assertTrue("changed", result);
        assertEquals("size_2", 2, myArrayList.size() );

        result = myArrayList.add("test3");
        assertTrue("changed", result);
        assertEquals("size_3", 3, myArrayList.size() );

        result = myArrayList.add("test4");
        assertTrue("changed", result);
        assertEquals("size_4", 4, myArrayList.size() );

        result = myArrayList.add("test5");
        assertTrue("changed", result);
        assertEquals("size_5", 5, myArrayList.size() );
    }

    @Test
    public void size() throws Exception {
        MyArrayListV<String> myArrayList = new MyArrayListV<>();
        assertEquals("size_0", 0, myArrayList.size() );

        myArrayList.add("test1");
        assertEquals("size_1", 1, myArrayList.size() );
    }

    @Test
    public void isEmpty() throws Exception {
        MyArrayListV<String> myArrayList = new MyArrayListV<>();
        assertTrue("isEmpty_true", myArrayList.isEmpty());

        myArrayList.add("notEmpty");
        assertFalse("isEmpty_false", myArrayList.isEmpty());
    }
}
