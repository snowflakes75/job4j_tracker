package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void move() {
        System.out.println("chu-chu");
    }

    @Override
    public void accommodationPassenger(int passangers) {
        System.out.println("accommodation " + passangers + " in Bus");
    }

    @Override
    public double fillUp(int fuel) {
        double price = 67.8;
        return fuel/price;
    }
}
