package ru.otus.ATM.Version2;


import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ATM oneATM = new ATM();
        int balanceOneATM = oneATM.balance();
        System.out.println("balance = " + balanceOneATM);

        System.out.println("Кладем 10 по 100");
        oneATM.put(Currency.HUNDRED,10);

        balanceOneATM = oneATM.balance();
        System.out.println("balance = " + balanceOneATM);

        System.out.println("Снимаем 900");
        var pars = oneATM.get(900);
        for (var par : pars.keySet()){
            System.out.println("Номинал: " + par + " Колличество: " + pars.get(par));
        }
        balanceOneATM=oneATM.balance();
        System.out.println("balance = " + balanceOneATM);


        System.out.println("Кладем 2 по 200");
        oneATM.put(Currency.TWO_HUNDRED,2);
        System.out.println("balance = " + oneATM.balance());


    }

}
