package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean same = false;
        Map<String, Integer> dc = new HashMap<>();
        String[] arrLeft = left.split("");
        for (int i = 0; i < arrLeft.length; i++) {
            if (!dc.containsKey(arrLeft[i])) {
                dc.put(arrLeft[i], 1);
            } else {
                int num = dc.get(arrLeft[i]);
                dc.put(arrLeft[i], ++num);
            }
        }
        String[] arrRight = right.split("");
        for (String st : arrRight) {
            if (!dc.containsKey(st)) {
                return false;
            } else if (dc.get(st) == 1) {
                dc.remove(st);
            } else if (dc.get(st) > 1) {
                int num = dc.get(st);
                dc.put(st, --num);
            }
        }
        return dc.isEmpty();
    }
}