package ru.otus.ATM.Version2;

public class SimpleBox implements Box {

    int count;

    public SimpleBox(int count) {
        this.count = count;
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
    public void removeFromBox(int count) {
        if(isGet(count)){
            this.count-=count;
        }
    }

    @Override
    public boolean isGet(int count) {
        if(count>this.count||count<=0){
            return false;
        }
        return true;
    }
}
