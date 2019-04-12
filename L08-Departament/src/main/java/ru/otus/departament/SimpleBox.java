package ru.otus.departament;

public class SimpleBox   {

    private final Currency currency;
    
    private int count;

    public SimpleBox(Currency currency, int count) {
        this.currency = currency;
        this.count = count;
    }

    public SimpleBox(SimpleBox box) {
        this.currency=box.currency;
        this.count=box.count;
    }

    public SimpleBox clone()  {
        return new SimpleBox(this.currency,this.count);
    }

    public void add(int count) {
        if (count<=0) {
            System.out.println("Неккоректная сумма");
            return;
        }
        this.count+=count;
    }

    public int getCount() {
        return this.count;
    }

    public void removeFromBox(int count) {
        if(isGet(count)){
            this.count-=count;
        }
    }

    public boolean isGet(int count) {
        if(count>this.count||count<=0){
            return false;
        }
        return true;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
