package ru.otus.ATM.Version2;


public class Main {
    public static void main(String[] args) {

        ATM oneATM = new ATM();
        int balanceOneATM = oneATM.balance();
        System.out.println("balance = " + balanceOneATM);

        oneATM.put(new Hundred(10));

        balanceOneATM = oneATM.balance();

        System.out.println("balance = " + balanceOneATM);

        var pars = oneATM.get(700);
        System.out.println("Снимаем 700");
        for (var par : pars.keySet()){
            System.out.println("Номинал: " +par + " Колличество: " + pars.get(par));
        }

        balanceOneATM=oneATM.balance();

        System.out.println("balance = " + balanceOneATM);


        oneATM.put(new Hundred(-1));
        balanceOneATM=oneATM.balance();
        System.out.println("balance = " + balanceOneATM);
        oneATM.get(-100);
        balanceOneATM=oneATM.balance();
        System.out.println("balance = " + balanceOneATM);


        System.out.println("----------");
        ATM forCheckAlgoritm = new ATM();
        forCheckAlgoritm.get(700);
        int balance = forCheckAlgoritm.balance();
        System.out.println(balance);
    }

}
