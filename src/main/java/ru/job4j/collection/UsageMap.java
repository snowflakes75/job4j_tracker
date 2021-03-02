package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("some@yahoo.com", "FIO");
        for (Map.Entry entry: map.entrySet()) {
            System.out.println("Email: " + entry.getKey() + " | Fio: " + entry.getValue());
        }
    }
}
