package com.java.lru;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

//        LRUCache cache = new LRUCache(3);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.put(3,3);
//        System.out.println(cache.cache);
//        cache.put(4,4);
//        System.out.println(cache.cache);
//        cache.printLinkedList();
        Map<String, Integer> map = new HashMap<>();
        map.put("x", 24);
        map.put("y", 25);
        map.put("z", 26);

        List<String> entriesList = map.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.toList());
        System.out.println(entriesList);
        map.entrySet().forEach(stringIntegerEntry -> entriesList.add(stringIntegerEntry.getKey()));
        System.out.println(entriesList);
    }
}
