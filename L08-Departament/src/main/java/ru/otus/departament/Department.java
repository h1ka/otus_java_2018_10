package ru.otus.departament;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Department {
    List<ATM> atmList;

    Map<ATM,ATMState> stateMap;

    public Department(List<ATM> atmList) {
        this.atmList = atmList;
        stateMap = atmList.stream()
                .collect(Collectors.toMap(atm -> atm, atm -> atm.saveState()));
    }
    public void restore(){
        stateMap.forEach(((atm, atmState) -> atm.restore(atmState)));
    }
    public long getBalance(){
        int balance = 0;
        for (ATM atm : atmList){
            balance+=atm.balance();
        }
        return balance;
    }
}
