package ru.job4j.ood.exam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAccounts implements  Export {

    private Map<String, Account> accounts = new HashMap<>();

    public PrintAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void export(String message) {
        System.out.println("Текущие балансы " + message + ":");
        for (Account acc : accounts.values()) {
            System.out.println(acc.getId() + " -> " + acc.getBalance());
        }
    }
}
