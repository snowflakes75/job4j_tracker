package ru.job4j.stream;

import java.util.stream.Stream;

public class Card {
    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit=" + suit
                + ", value=" + value
                + '}';
    }

    public static void main(String[] args) {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                System.out.println(new Card(suit, value));
            }
        }

        System.out.println();

        Stream.of(Suit.values())
                .flatMap(e -> Stream.of(Value.values()).map(v -> new Card(e, v)))
                .forEach(System.out::println);
    }
}

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8
}
