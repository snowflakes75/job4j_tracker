package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double x = i;
            arr.add(func.apply(Double.valueOf(x)));
        }
        return arr;
    }
}
