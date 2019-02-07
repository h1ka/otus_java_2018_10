package ru.otus.ATM.Version2;

public class BoxFactory {

    static Box getBox(int count){
        return new SimpleBox(count);
    }

}
