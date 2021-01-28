package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullname("Vladimir Snegir");
        student.setGroup(1234);
        student.setEnterDate(LocalDate.now());
        System.out.println(student.toString());
    }
}
