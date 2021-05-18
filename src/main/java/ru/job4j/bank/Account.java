package ru.job4j.bank;

import java.util.Objects;

/**
 * Аккаунт пользователя в банковской системе
 *
 * @author MГ
 * @version 1
 */
public class Account {
    /**
     * requisite - реквизиты счета
     * balance - баланс счета
     */
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * @return вернет реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * @param requisite Устанавливает реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
