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
        /*ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals(key)
                    || person.getSurname().equals(key)
                    || person.getPhone().equals(key)
                    || person.getAddress().equals(key)) {
                result.add(person);
            }
        }*/

        Predicate<Person> combine = person -> {
            Optional<Boolean> result = Optional.of(person.getName().equals(key))
                    .or(() -> Optional.of(person.getSurname().equals(key)))
                    .or(() -> Optional.of(person.getPhone().equals(key))
                            .or(() -> Optional.of(person.getAddress().equals(key))));
            return result.get();
        };
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}