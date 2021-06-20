package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean same = false;
        Map<String, Integer> dc = new HashMap<>();
        String[] arrLeft = left.split("");
        for (String s : arrLeft) {
            if (!dc.containsKey(s)) {
                dc.put(s, 1);
            } else {
                dc.put(s, dc.get(s) + 1);
            }
        }

        String[] arrRight = right.split("");
        for (String st : arrRight) {
            if (!dc.containsKey(st)) {
                return false;
            } else if (dc.get(st) == 1) {
                dc.remove(st);
            } else if (dc.get(st) > 1) {
                dc.put(st, dc.get(st) - 1);
            }
        }
        return dc.isEmpty();
    }
}