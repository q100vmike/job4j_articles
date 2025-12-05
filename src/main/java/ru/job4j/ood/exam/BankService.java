package ru.job4j.ood.exam;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<String, Account> accounts = new HashMap<>();
    private double fee = 0.015;

    public BankService() {

    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void registerAccount(String id, double initialBalance, boolean vip) {
        accounts.put(id, new Account(id, initialBalance, vip));
        System.out.println("Аккаунт " + id + " зарегистрирован. VIP=" + vip);
    }

    public void transfer(String fromId, String toId, double amount) {
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        if (from == null || to == null) {
            System.out.println("ОШИБКА: аккаунт не найден");  // логирование внутри — ещё SRP нарушение
            return;
        }

        if (from.getBalance() < amount) {
            System.out.println("ОШИБКА: недостаточно средств");
            return;
        }

        from.setBalance(AccountUtils.withdraw(from.getBalance(), amount + (amount * fee)));

        to.setBalance(AccountUtils.deposit(to.getBalance(), amount));

        System.out.println("Перевод " + amount + " от " + fromId + " к " + toId + ". Комиссия: " + fee);
        System.out.println("SMS: перевод выполнен успешно");
    }
}
