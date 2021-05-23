package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Supplier<String> sup = () -> "New string for interface";
        Supplier<String> sur = new Supplier<String>() {
            @Override
            public String get() {
                return "Some str";
            }
        };
        System.out.println(sup.get());
        System.out.println(sur.get());

        List<String> list = List.of("1", "2", "3");
        Supplier<Set<String>> supSet = () -> new HashSet<>(list);
        Set<String> strings = supSet.get();
        for (String s: strings) {
            System.out.println(s);
        }

        Supplier<String> sp = () -> "new message";
        Consumer<String> cons = (s) -> System.out.println(s);
        cons.accept(sp.get());

        BiConsumer<String, String> biConsumer = (s, s1) -> System.out.println(s + s1);
        biConsumer.accept(sp.get(), sup.get());

        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("строка пустая " + pred.test(""));
        System.out.println("строка пустая " + pred.test("none"));
    }
}
