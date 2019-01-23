package ru.otus.MyCache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.MyCache.HWCache.BigObject;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BigObjectTest")
public class BigObjectTest {

    @Test
    @DisplayName("getArrayTest")
      void getArrayTest(){
        BigObject bigObject = new BigObject();
        byte[] myArray = new byte[1024 * 1024];
        int length1 = myArray.length;
        byte[] array = bigObject.getArray();
        int length = array.length;
        assertEquals(length1,length);
    }

}
