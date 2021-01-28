package ru.job4j.professions;

public class Builder extends Engineer {
    private String tool;

    public Builder(String name, String surname, String education, String birthday, int limit, String tool) {
        super(name, surname, education, birthday, limit);
        this.tool = tool;
    }

    public String getTool() {
        return tool;
    }
}
