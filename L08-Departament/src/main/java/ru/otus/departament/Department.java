package ru.otus.departament;

import java.util.*;
import java.util.stream.Collectors;

public class Department {
    private List<ATM> atmList;
    private Map<ATM,ATMState> stateMap;
    private Queue<Command> commands ;
    private List<Listener> listeners;
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
        return listeners.stream().mapToLong(listener -> listener.executeCommand(new Balance())).sum();
     }
}
