package ru.otus.departament;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SimpleBox one = new SimpleBox(Currency.HUNDRED,4);
        SimpleBox two = new SimpleBox(Currency.FIVE_HUNDRED,4);
        SimpleBox three = new SimpleBox(Currency.TWO_HUNDRED,4);

        SimpleBox atm2one = new SimpleBox(Currency.HUNDRED,2);
        SimpleBox atm2two = new SimpleBox(Currency.FIVE_HUNDRED,2);
        SimpleBox atm2three = new SimpleBox(Currency.TWO_HUNDRED,2);

        SimpleBox atm3one = new SimpleBox(Currency.HUNDRED,5);
        SimpleBox atm3two = new SimpleBox(Currency.FIVE_HUNDRED,5);
        SimpleBox atm3three = new SimpleBox(Currency.TWO_HUNDRED,5);

        List<SimpleBox> list = Arrays.asList(one,two,three);
        List<SimpleBox> list2 = Arrays.asList(atm2one,atm2two,atm2three);
        List<SimpleBox> list3 = Arrays.asList(atm3one,atm3two,atm3three);

        ATM atm = new ATM(list);
        ATM atm2 = new ATM(list2);
        ATM atm3 = new ATM(list3);

        List<ATM> listATM = Arrays.asList(atm,atm2,atm3);

        System.out.println(atm.balance());
        System.out.println(atm2.balance());
        System.out.println(atm3.balance());

        Department department = new Department(listATM);

        System.out.println("begin balance" + department.getBalance());

        atm.put(Currency.HUNDRED,1);
        atm2.put(Currency.TWO_HUNDRED,4);

        System.out.println("after balance" + department.getBalance());
        department.restore();
        System.out.println("restore balance" + department.getBalance());
    }
}
