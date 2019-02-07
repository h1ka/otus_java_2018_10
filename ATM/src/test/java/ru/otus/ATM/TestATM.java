package ru.otus.ATM;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ATM.Version2.ATM;
import ru.otus.ATM.Version2.Currency;



import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("ATM test")
public class TestATM {


    @Test
    @DisplayName("put money")
    void testPutMoney(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.put(Currency.HUNDRED,100);
        int expectedBalance = oldBalance+10000;
        assertEquals(expectedBalance,atm.balance());
    }

    @Test
    @DisplayName("put money with negative value")
    void testPutMoneyWithNegativeValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.put(Currency.FIVE_HUNDRED,-100);
        assertEquals(oldBalance,atm.balance());
    }

    @Test
    @DisplayName("removeFromBox money with negative value")
    void testGetMoneyWithNegativeValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(-100);
        assertEquals(oldBalance,atm.balance());
    }

    @Test
    @DisplayName("removeFromBox money")
    void testGetMoney(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        atm.get(500);
        int expectedBalance = oldBalance-500;
        assertEquals(expectedBalance,atm.balance());
    }

    @Test
    @DisplayName("removeFromBox money with big value")
    void testGetMoneyWithBigValue(){
        ATM atm = new ATM();
        int oldBalance = atm.balance();
        int bigValue = oldBalance*2;
        atm.get(bigValue);
        assertEquals(oldBalance,atm.balance());
    }



}
