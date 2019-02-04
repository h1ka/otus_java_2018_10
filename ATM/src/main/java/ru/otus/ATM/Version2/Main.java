package ru.otus.ATM.Version2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ATM oneATM = new ATM();
        ATM twoATM = new ATM();

        int balanceOneATM = oneATM.balance();
        int balanceTwoATM = twoATM.balance();

        oneATM.put(new Hundred(10));
        twoATM.put(new FiveHundred(100));

        balanceOneATM = oneATM.balance();
        balanceTwoATM = twoATM.balance();

        System.out.println("balance ONE = " + balanceOneATM);
        System.out.println("balance TWO = " + balanceTwoATM);

        var pars = oneATM.get(700);
        System.out.println("Снимаем 700");
        for (var par : pars.keySet()){
            System.out.println("Номинал: " +par + " Колличество: " + pars.get(par));
        }

        var pars2 = twoATM.get(7300);
        System.out.println("Снимаем 7300");
        for (var par : pars2.keySet()){
            System.out.println("Номинал: " +par + " Колличество: " + pars2.get(par));
        }

        balanceOneATM=oneATM.balance();
        balanceTwoATM=twoATM.balance();

        System.out.println("balance ONE = " + balanceOneATM);
        System.out.println("balance TWO = " + balanceTwoATM);


        oneATM.put(new Hundred(-1));
        balanceOneATM=oneATM.balance();
        System.out.println("balance ONE = " + balanceOneATM);
        oneATM.get(-100);
        balanceOneATM=oneATM.balance();
        System.out.println("balance ONE = " + balanceOneATM);

    }

}
