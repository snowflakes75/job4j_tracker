package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamZero {
    public static void main(String[] args) {
        List<Integer> ls = List.of(1, 2, -3, 4, 5);
        List<Integer> posNums = ls.stream().filter(num -> num > 0).collect(Collectors.toList());
        System.out.println(posNums);
    }
}
