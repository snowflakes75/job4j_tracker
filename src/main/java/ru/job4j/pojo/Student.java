package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String fullname;
    private int group;
    private LocalDate enterDate;

    @Override
    public String toString() {
        return "Student "
                + "fullname - " + fullname
                + ", group " + group
                + ", enterDate: " + enterDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public LocalDate getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(LocalDate enterDate) {
        this.enterDate = enterDate;
    }
}
