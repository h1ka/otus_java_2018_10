package com.trap.MyArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List arrayList = new MyArrayList();
        List myArrayList = new MyArrayList();
        List arrayTest = new MyArrayList(10);
        arrayTest.add(1);
        System.out.println("size= " + arrayTest.size());
        for (int i =0;i<10;i++){
            arrayList.add(i);
            myArrayList.add(i+1000);
        }

//        arrayList.add(11);
//        arrayList.add(12);
//        arrayList.add(13);
//
//        myArrayList.add(31);
//        myArrayList.add(32);
//        myArrayList.add(33);


        System.out.println(arrayList.set(1,22));
        System.out.println("1 = " + arrayList.get(1));

       Collections.addAll(arrayList,myArrayList);
       //Collections.copy(arrayList,myArrayList);
       //Collections.sort(arrayList,Collections.reverseOrder());

        System.out.println("sort");
        System.out.println("---------\nArrayList" );
        for (Object element:
             arrayList) {
            System.out.print(element + " ");
        }
        System.out.println("\n---------\nMyArrayList" );
        for (Object element:
                myArrayList) {
            System.out.print(element + " ");
        }



    }
}

