package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean same = true;
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
            if (!dc.containsKey(st) || dc.get(st) <= 0) {
                same = false;
                break;
            } else {
                int num = dc.get(st);
                dc.put(st, --num);
            }
        }
        return same;
    }
}