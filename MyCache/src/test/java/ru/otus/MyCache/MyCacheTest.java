package ru.otus.MyCache;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.MyCache.HWCache.MyCache;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MyCacheTest")
 class MyCacheTest {
    static MyCache myCache = new MyCache();

    @Test
    @DisplayName("putTestNotNull")
      void putTestNotNull(){
        myCache.put(1,1);
        assertNotNull(myCache.get(1));
    }

    @Test
    @DisplayName("putTest")
      void putTest() {
        var put = myCache.put(3, 3);
        assertEquals(3,put);
    }

    @Test
    @DisplayName("removeTest")
    void removeTest(){
        myCache.remove(3);
        assertNull(myCache.get(3));
    }

    @Test
    @DisplayName("sizeTestNotNull")
    void sizeTestNotNull(){
        int size = myCache.size();
        assertNotNull(size);
    }
}
