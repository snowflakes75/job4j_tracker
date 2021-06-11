package ru.job4j.search;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {

        Predicate<Person> checkEqName = person -> person.getName().equals(key);
        Predicate<Person> checkEqSurname = person -> person.getSurname().equals(key);
        Predicate<Person> checkEqPhone = person -> person.getPhone().equals(key);
        Predicate<Person> checkEqAddress = person -> person.getAddress().equals(key);

        Predicate<Person> combine = checkEqName.or(checkEqSurname).or(checkEqPhone).or(checkEqAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}