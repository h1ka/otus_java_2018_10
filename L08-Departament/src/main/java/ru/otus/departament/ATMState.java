package ru.otus.departament;

import java.util.HashMap;
import java.util.Map;

public class ATMState {
    private final Map<Currency,SimpleBox> boxMap;

    public ATMState(Map<Currency,SimpleBox> boxMap) {
        Map<Currency,SimpleBox> boxMapCopy = new HashMap<>();
        for (Map.Entry<Currency,SimpleBox> entry: boxMap.entrySet()){
            boxMapCopy.put(entry.getKey(),entry.getValue().clone());
        }
        this.boxMap=boxMapCopy;
    }

    public Map<Currency, SimpleBox> getState() {
      return boxMap;
    }
}
