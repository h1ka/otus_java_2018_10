package ru.otus.ATM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ATM.Version2.ATM;
import ru.otus.ATM.Version2.FiveHundred;
import ru.otus.ATM.Version2.Hundred;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ATM test")
public class TestATM {


    @Test
    @DisplayName("put money")
    void testPutMoney(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.put(new Hundred(100));
        int expectedBalance = oldBalance+10000;
        assertEquals(expectedBalance,atm.balance());
    }

    @Test
    @DisplayName("put money with negative value")
    void testPutMoneyWithNegativeValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.put(new FiveHundred(-100));
        assertEquals(oldBalance,atm.balance());
    }

    @Test
    @DisplayName("get money with negative value")
    void testGetMoneyWithNegativeValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(-100);
        assertEquals(oldBalance,atm.balance());
    }

    @Test
    @DisplayName("get money")
    void testGetMoney(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(500);
        int expectedBalance = oldBalance-500;
        assertEquals(expectedBalance,atm.balance());
    }
    @Test
    @DisplayName("get money with big value")
    void testGetMoneyWithBigValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(1000000);
        assertEquals(oldBalance,atm.balance());
    }

    @Test
    @DisplayName("get money with big count par")
    void testGet(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(700);
        assertEquals(oldBalance,atm.balance());
    }


}
