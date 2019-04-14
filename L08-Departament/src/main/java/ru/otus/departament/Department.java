package ru.otus.departament;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class Department {
    List<ATM> atmList;
    Map<ATM,ATMState> stateMap;
    Queue<Command> commands ;
    List<Listener> listeners;
    public Department(List<ATM> atmList) {
        this.atmList = atmList;
        stateMap = atmList.stream()
                .collect(Collectors.toMap(atm -> atm, ATM::saveState));
    }
    public void restore(){
        stateMap.forEach((ATM::restore));
    }
    public long getBalance(){
        listeners=new ArrayList<>();
        commands = new LinkedList<>();
        listeners.addAll(atmList);

        listeners.forEach(listener -> commands.add(new Balance(listener)));
        return commands.stream().mapToLong(Command::execute).sum();
     }
}
