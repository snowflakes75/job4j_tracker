package ru.job4j.professions;

public class Dentist extends Doctor {
    private int degree;

    public Dentist(String name, String surname, String education, String birthday, String hospital, int degree) {
        super(name, surname, education, birthday, hospital);
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
}
