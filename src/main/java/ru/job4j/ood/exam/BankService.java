package ru.job4j.ood.exam;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<String, Account> accounts = new HashMap<>();

    private Logger accountLogger;

    public BankService(Logger accountLogger) {
        this.accountLogger = accountLogger;
    }

    public Map<String, Account> getAccounts() {
        Map<String, Account> copy = new HashMap<>(accounts);
        return copy;
    }

    public void registerAccount(String id, double initialBalance, boolean vip) {
        accounts.put(id, new Account(id, initialBalance, vip));
        accountLogger.log("Аккаунт " + id + " зарегистрирован. VIP=" + vip);
    }

    public void transfer(String fromId, String toId, double amount) {
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        FeeCalculator feeCalculator = new FeeCalculator(from.isVip());
        double fee = feeCalculator.getFee();

        if (from == null || to == null) {
            accountLogger.errorNofLog();  // логирование внутри — ещё SRP нарушение
            return;
        }

        if (from.getBalance() < amount) {
            accountLogger.errorNoMoneyLog();
            return;
        }

        from.setBalance(AccountUtils.withdraw(from.getBalance(), amount + (amount * fee)));

        to.setBalance(AccountUtils.deposit(to.getBalance(), amount));

        accountLogger.log("Перевод " + amount + " от " + fromId + " к " + toId + ". Комиссия: " + fee);
        accountLogger.successLog();
    }
}
