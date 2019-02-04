package ru.otus.ATM.Version2;


public class FiveHundredBox implements Box {
    private int count;

    public FiveHundredBox(FiveHundred fiveHundred) {
        this.count = fiveHundred.getCount();
    }

    @Override
    public void add(int count) {
        this.count+=count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public void get(int count) {

        if(count>this.count||count<=0){
            System.out.println("Неккоректное значение");
        } else
        this.count-=count;
    }
}
