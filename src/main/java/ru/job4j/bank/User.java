package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Пользователя
 *
 * @author МГ
 * @version 1
 */
public class User {
    /**
     * Паспортные данные челевока
     * Фамилия пользователя
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * @return вернут паспортные данные
     */
    public String getPassport() {
        return passport;
    }

    /**
     * @param passport Устанавливают паспортные данные
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * @return фамилию пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username устанавливают фамилию пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
