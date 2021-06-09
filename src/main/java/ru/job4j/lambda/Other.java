package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Other {
    public static void main(String[] args) {
        String[] names = {
                "Ivan",
                "Bob"
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        String[] sur = {
                "Fran"
        };
        Arrays.sort(names, lengthCmp);
        Arrays.sort(sur, lengthCmp);
    }
}
