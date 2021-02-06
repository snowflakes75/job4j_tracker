package ru.job4j.oop;

public class Airplane implements Vehicle {
    public void move() {
        System.out.println("Air move");
    }

    @Override
    public void showPassenger() {
        System.out.println(60);
    }
}
