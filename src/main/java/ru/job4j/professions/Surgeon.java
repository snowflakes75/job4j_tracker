package ru.job4j.professions;

public class Surgeon extends Doctor {
    private boolean senior;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   String hospital, boolean senior) {
        super(name, surname, education, birthday, hospital);
        this.senior = senior;
    }

    public boolean isSenior() {
        return senior;
    }
}
