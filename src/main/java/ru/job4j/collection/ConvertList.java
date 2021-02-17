package ru.job4j.collection;

import java.util.*;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] arrs: list) {
            for (int elem: arrs) {
                rsl.add(elem);
            }
        }
        return rsl;
    }
}
