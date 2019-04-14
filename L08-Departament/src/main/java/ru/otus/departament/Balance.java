package ru.otus.departament;
public class Balance implements Command {

    @Override
    public long execute(ATM atm) {
        return atm.balance();
    }

}
