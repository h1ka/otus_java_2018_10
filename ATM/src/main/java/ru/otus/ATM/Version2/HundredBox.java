package ru.otus.ATM.Version2;

import java.util.Objects;

public class HundredBox implements Box {

    int count =0;

    public HundredBox(Hundred hundred) {
        count+=hundred.getCount();
    }


    @Override
    public void add(int count) {
        if (count<=0) {
            System.out.println("Неккоректная сумма");
            return;
        }
        this.count+=count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public boolean get(int count) {
        if(count>this.count||count<=0){
            return false;
        } else
            this.count-=count;
        return true;
    }
}
