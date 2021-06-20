package ru.job4j.collection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (el.startsWith("k")) {
                    tmp.add(el);
                    start = el;
                } else {
                    start = start + "/" + el;
                    tmp.add(start);
                }
            }
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort((o2, o1) -> o2.compareTo(o1));
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}