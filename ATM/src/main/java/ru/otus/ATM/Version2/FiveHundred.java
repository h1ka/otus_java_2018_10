package ru.otus.ATM.Version2;

import java.util.Objects;

public class FiveHundred implements Par {
    private final int VALUE=500;
    private int count =0;

    public FiveHundred() {
    }

    public FiveHundred(int count) {
        if (count<0) {
            System.out.println("Неккоректная сумма");
            return;
        }
        this.count = count;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FiveHundred that = (FiveHundred) o;
        return VALUE == that.VALUE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(VALUE);
    }

    @Override
    public String toString() {
        return ""+VALUE;
    }

    @Override
    public int getValue() {
        return VALUE;
    }
}
