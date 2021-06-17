package ru.job4j.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean generated = true;
        Set<String> text = new HashSet<>(
                Arrays.asList(
                        origin.replaceAll("[.,!]","").split(" ")));
        String[] search = line.replaceAll("[.,!]","").split(" ");
        for (String st : search) {
            if (!text.contains(st)) {
                generated = false;
                break;
            }
        }
        return generated;
    }
}