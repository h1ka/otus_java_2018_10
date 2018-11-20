package com.trap.Arr;

import java.util.Arrays;

public class StackIntArray implements IStack {
    private int[] array;
    private int k;
    private int i =0;
    public StackIntArray(){
        this.array=new int[i];
        this.k =-1;
    }
    public void push(int x) {
        k++;
        i++;
        array=Arrays.copyOf(array,i);
        array[k] = x;
    }

    public int pop() {
        if (k==-1){
            throw new RuntimeException("array is empty");
        }
        else {
            int t = array[k];
            k--;
            array=Arrays.copyOf(array,i);
            return t;
        }

    }
}
