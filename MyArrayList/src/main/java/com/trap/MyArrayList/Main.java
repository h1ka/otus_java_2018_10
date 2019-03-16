package com.trap.MyArrayList;

import com.trap.MyArrayList.types.MyArrayListV;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> arrayList = new MyArrayListV();
        for (int i =0;i<10;i++){
            arrayList.add(i);
        }
        arrayList.add(55);
        arrayList.add(555);
        arrayList.add(15);
        arrayList.add(5);


        System.out.println("arrayList " + arrayList);
        System.out.println("\n--------");
        System.out.println("sort");
        Collections.sort(arrayList,Collections.reverseOrder());
        System.out.println("arrayList " + arrayList);


        System.out.println("\n--------");
        System.out.println("addAll");
        Collections.addAll(arrayList,1, 2, 3);
        System.out.println("arrayList " + arrayList);


        List myArrayList = new MyArrayListV();
        for (int i = 10; i>0 ; i--) {
            myArrayList.add(i+1000);
        }

        System.out.println("\n--------");
        System.out.println("copy");
        System.out.println("myArrayList" + myArrayList);
        Collections.copy(arrayList,myArrayList);
        System.out.println("arrayList" + arrayList);
        System.out.println("\n--------foreach arrayList");
        for (var a:arrayList) {
            System.out.print(a+" ");
        }

      
    }
}

