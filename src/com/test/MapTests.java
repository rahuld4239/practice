package com.test;

import java.util.HashMap;
import java.util.Map;

public class MapTests {

    Map<Integer, String> map = new HashMap<>();

    public MapTests() {
        map.put(1, "Grape");
        map.put(2, "Apple");
        map.entrySet()
                .removeIf(entry -> entry.getValue().equals("Grape"));
    }

    public void printMap() {

        System.out.println(map);

    }
}
