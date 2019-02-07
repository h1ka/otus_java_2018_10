package ru.otus.ATM.Version2;


public enum Currency {

    HUNDRED(100),
    FIVE_HUNDRED(500),
    TWO_HUNDRED(200);

    private int value;
    Currency(int value) {
        this.value=value;
    }
    public int getValue() {
        return value;
    }

}
