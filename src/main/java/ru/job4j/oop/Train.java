package ru.job4j.oop;

public class Train implements Vehicle {
    public void move() {
        System.out.println("Train move");
    }

    @Override
    public void showPassenger() {
        System.out.println(200);
    }
}
