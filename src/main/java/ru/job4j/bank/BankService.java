package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс имулирующий работу банковского сервиса
 *
 * @author MГ
 * @version 1
 */
public class BankService {
    /**
     * Мапа хранящия юзера и связанных с ним аккаунты
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавдляющий в ИС пользователя
     *
     * @param user - пользователь для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавить аккаунт к пользователю
     *
     * @param passport - паспорт
     * @param account  - аккаунт который необходимо привязать
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Поиск пользователя по паспорту
     *
     * @param passport паспорт пользователя для поиска
     * @return верент пользователя
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Вернет аккаунт по реквизиту счета
     *
     * @param passport  паспорт
     * @param requisite реквизит счета
     * @return Подходящий аккаунт или null, если такого нету
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод эмулирующий транзакцию между счетами
     *
     * @param srcPassport   - паспортные данные отправителя
     * @param srcRequisite  - реквизиты отправителя
     * @param destPassport  = паспортные данные получателя
     * @param destRequisite = реквизиты получателя
     * @param amount        - сумма перевода
     * @return результат передачи денег, вернет false если баланс не позволяет
     * совершить транзакцию
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account sendAcc = findByRequisite(srcPassport, srcRequisite);
        Account receiveAcc = findByRequisite(destPassport, destRequisite);
        if (sendAcc != null && receiveAcc != null && sendAcc.getBalance() - amount >= 0) {
            rsl = true;
            receiveAcc.setBalance(receiveAcc.getBalance() + amount);
            sendAcc.setBalance(sendAcc.getBalance() - amount);
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        String requisite = "3fdsbb9";
        accounts.add(new Account("3fdsbb9", 140));
        int index = accounts.indexOf(new Account(requisite, -1));
        Account find = accounts.get(index);
        System.out.println(find.getRequisite() + " -> " + find.getBalance());
    }
}
