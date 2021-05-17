package ru.job4j.oop;

public class Bus implements Vehicle {
    public void move() {
        System.out.println("Bus move");
    }

    @Override
    public void showPassenger() {
        System.out.println(20);
    }
}
