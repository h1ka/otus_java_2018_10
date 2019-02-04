package ru.otus.ATM.Version2;

import java.util.*;

public class ATM {
    private Map<Par,Box> boxMap = new HashMap<>();

    public ATM() {
        boxMap.put(new Hundred(),new HundredBox(new Hundred(1)));
        boxMap.put(new FiveHundred(),new FiveHundredBox(new FiveHundred(5)));
    }

    public void put(Par par){
        Box box = boxMap.get(par);
        box.add(par.getCount());
    }

    public Map<Par,Integer> get(int sum){
        if(sum<100){
            System.out.println("Введите корректную сумму");
            return null;
        }
        if (sum>this.balance()) {
            System.out.println("В банкомате недостаточно средств");
            return null;
        }

        Map<Par,Integer> cash = new HashMap<>();

        Par[] parInBoxes = sortedValueParInBoxes();

        for (int i =parInBoxes.length-1 ;i >=0;i--){
            int value=parInBoxes[i].getValue();
            if(sum/value!=0) {
                int countPar = sum / value;
                Box box = boxMap.get(parInBoxes[i]);
                while (countPar!=0) {
                    if(box.isGet(countPar)) {
                        sum = sum - countPar * value;
                        cash.put(parInBoxes[i], countPar);
                        break;
                    } else countPar--;
                }
            }
        }
        if (sum!=0) {
            System.out.println("В банкомате не достаточно средсв");
            return null;
        }
        for (var par:cash.keySet() ){
            boxMap.get(par).get(cash.get(par));
        }
        return cash;
    }

    private Par[] sortedValueParInBoxes(){
        Par[] parsInBoxes = new Par[boxMap.size()];
        int i = 0;
        for (var par : boxMap.keySet()){
            parsInBoxes[i++]=par;
        }
        for (int j =0; j<parsInBoxes.length;j++){
            for (int k =0; k<parsInBoxes.length;k++){
                if (parsInBoxes[k].getValue()>parsInBoxes[j].getValue()){
                    var temp = parsInBoxes[j];
                    parsInBoxes[j]=parsInBoxes[k];
                    parsInBoxes[k]=temp;
                }
            }
        }
        return parsInBoxes;
    }
    public int balance(){
        int sum=0;
        for (var box : boxMap.keySet()){
            sum+=box.getValue()*boxMap.get(box).getCount();
        }
        return sum;

    }
}
