package ru.job4j.professions;

public class Engineer extends Profession {
    private int limit;

    public Engineer(String name, String surname, String education, String birthday, int limit) {
        super(name, surname, education, birthday);
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }
}
