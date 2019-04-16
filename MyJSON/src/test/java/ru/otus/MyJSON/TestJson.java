package ru.otus.MyJSON;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Tests MyGson.Class equals com.google.gson.Gson")
public class TestJson {
    MyGson json = new MyGson();
    Gson gson = new Gson();

    @DisplayName("should Json for BagOfPrimitives.class")
    @Test
    void shouldJsonForBagOfPrimitivesAsGson(){
        BagOfPrimitives obj = new BagOfPrimitives(1,"otus",3);
        String actualJSON = json.toJson(obj);
        System.out.println(actualJSON);
        String extendJSON = gson.toJson(obj);
        System.out.println(extendJSON);

        assertEquals(extendJSON,actualJSON);
    }

    @DisplayName("should Json for String")
    @Test
    void shouldJsonHowArray(){
        String str = "string";
        String actualJSON = json.toJson(str);
        String extendJSON = gson.toJson(str);
        assertEquals(extendJSON,actualJSON);
    }


    @DisplayName("should Json for ClassForJson.class")
    @Test
    void testClassForJson(){
        ClassForJson classForJson = new ClassForJson(1,"otus",3);
        String actualJSON = json.toJson(classForJson);
        String expectedJSON = gson.toJson(classForJson);
        assertEquals(expectedJSON,actualJSON);
    }

    @DisplayName("should json for List,Set and Map")
    @Test
    void testCollectionsAndMap(){
        BagOfPrimitives obj = new BagOfPrimitives(1,"otus",1000);
        BagOfPrimitives obj2 = new BagOfPrimitives(2,"otus2",2000);

        List<BagOfPrimitives> list = new ArrayList<>();
        list.add(obj); list.add(obj2);
        Map<String,BagOfPrimitives> map= new HashMap<>();
        map.put("one",obj);
        map.put("two",obj2);

        Set<BagOfPrimitives> set = new HashSet<>();
        set.add(obj);
        set.add(obj2);
        assertEquals(gson.toJson(list),json.toJson(list));
        assertEquals(gson.toJson(set),json.toJson(set));
        assertEquals(gson.toJson(map),json.toJson(map));
    }
    @DisplayName("should json for primitives")
    @Test
    void testPrimitives(){
        int i = 1;
        byte b = 2;
        char ch = 'a';
        short sh = 122;
        long l = 22222;
        boolean bl = true;
        float f = 1.2f;
        double d = 1.3;
        assertEquals(gson.toJson(i),json.toJson(i));
        assertEquals(gson.toJson(b),json.toJson(b));
        assertEquals(gson.toJson(ch),json.toJson(ch));
        assertEquals(gson.toJson(sh),json.toJson(sh));
        assertEquals(gson.toJson(l),json.toJson(l));
        assertEquals(gson.toJson(bl),json.toJson(bl));
        assertEquals(gson.toJson(f),json.toJson(f));
        assertEquals(gson.toJson(d),json.toJson(d));

    }

    @DisplayName("should json for array primitives")
    @Test
    void testArrayPrimitives(){
        int[] arrayInt =  {1,2,3,4,5};
        assertEquals(gson.toJson(arrayInt),json.toJson(arrayInt));
    }
    @DisplayName("should json for array objects")
    @Test
    void testArrayObject(){
        BagOfPrimitives obj = new BagOfPrimitives(1,"otus",1000);
        Object[] objArray = {obj,obj,obj};
        assertEquals(gson.toJson(objArray),json.toJson(objArray));
    }
    @DisplayName("should json for array string")
    @Test
    void testArrayString() {
        String[] strings = {"onew","era","asdas"};
        assertEquals(gson.toJson(strings),json.toJson(strings));

    }
}
