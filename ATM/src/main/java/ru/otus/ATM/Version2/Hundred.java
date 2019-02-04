package ru.otus.ATM.Version2;

import java.util.Objects;

public class Hundred implements Par{
    private final int VALUE=100;

    private int count=0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hundred hundred = (Hundred) o;
        return VALUE == hundred.VALUE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(VALUE);
    }

    public Hundred() {
    }

    public Hundred(int count) {
        this.count=count;
    }
    @Override
    public int getCount(){
        return this.count;
    }

    @Override
    public int getValue() {
        return VALUE;
    }

    @Override
    public String toString() {
        return ""+VALUE;
    }
}
