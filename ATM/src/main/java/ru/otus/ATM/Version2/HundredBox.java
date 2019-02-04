package ru.otus.ATM.Version2;


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
    public void get(int count) {
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
