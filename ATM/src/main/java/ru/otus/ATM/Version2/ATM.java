package ru.otus.ATM.Version2;

import java.util.*;

public class ATM {
    private Map<Currency,Box> boxMap = new HashMap<>();

    public ATM() {
        boxMap.put(Currency.HUNDRED,BoxFactory.getBox(1));
        boxMap.put(Currency.FIVE_HUNDRED,BoxFactory.getBox(5));
        boxMap.put(Currency.TWO_HUNDRED,BoxFactory.getBox(1));
    }

    public void put(Currency currency,int count){
        if(count<0) return;
        Box box = boxMap.get(currency);
        box.add(count);
    }

    public Map<Currency,Integer> get(int sum){
        if(sum<0){
            System.out.println("Введите корректную сумму");
            return null;
        }
        if (sum>this.balance()) {
            System.out.println("В банкомате недостаточно средств");
            return null;
        }

        Map<Currency,Integer> cash = new HashMap<>();

        Currency[] currencyInBoxes = this.sortValuesOfCurrencies();

        for (int i =0 ;i <currencyInBoxes.length;i++){
            int value=currencyInBoxes[i].getValue();
            if(sum/value!=0) {
                int countPar = sum / value;
                Box box = boxMap.get(currencyInBoxes[i]);
                while (countPar!=0) {
                    if(box.isGet(countPar)) {
                        sum = sum - countPar * value;
                        cash.put(currencyInBoxes[i], countPar);
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
            boxMap.get(par).removeFromBox(cash.get(par));
        }
        return cash;
    }

    private Currency[] sortValuesOfCurrencies() {
        Currency[] currencies = new Currency[boxMap.size()];
        int i = 0;
        for (var value : boxMap.keySet()){
            currencies[i++]=value;
        }
        for (int j = 0; j<currencies.length-1;j++ ){
            for (int k = 1; k<currencies.length; k++){
                if ((currencies[j].getValue()) < (currencies[k].getValue())){
                    var temp = currencies[j];
                    currencies[j]=currencies[k];
                    currencies[k]=temp;
                }
            }
        }
        return currencies;
    }
    public int balance(){
        int sum=0;
        for (var box : boxMap.keySet()){
            sum+=box.getValue()*boxMap.get(box).getCount();
        }
        return sum;

    }

}

