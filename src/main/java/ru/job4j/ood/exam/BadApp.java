package ru.job4j.ood.exam;

import java.util.HashMap;
import java.util.Map;

public class BadApp {

    public static class BadAccount {
        protected String id;
        protected double balance;

        public BadAccount(String id, double balance) {
            this.id = id;
            this.balance = balance;
        }

//        public void withdraw(double amount) {
//            balance -= amount;
//        }
//
//         public void deposit(double amount) {
//            balance += amount;
//        }

        public String getId() {
            return id;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static class BadVipAccount extends BadAccount {

        public BadVipAccount(String id, double balance) {
            super(id, balance);
        }

//        @Override
//        public void withdraw(double amount) {
//            System.out.println("VIP-клиент " + id + " не теряет деньги при попытке списания " + amount);
//        }
    }

    public static class BadBankService {

        private Map<String, BadAccount> accounts = new HashMap<>();

        public void registerAccount(String id, double initialBalance, boolean vip) {
            if (vip) {
                accounts.put(id, new BadVipAccount(id, initialBalance));
            } else {
                accounts.put(id, new BadAccount(id, initialBalance));
            }
            System.out.println("Аккаунт " + id + " зарегистрирован. VIP=" + vip);
        }

        public void transfer(String fromId, String toId, double amount) {
            BadAccount from = accounts.get(fromId);
            BadAccount to = accounts.get(toId);

            if (from == null || to == null) {
                System.out.println("ОШИБКА: аккаунт не найден");  // логирование внутри — ещё SRP нарушение
                return;
            }

            if (from.getBalance() < amount) {
                System.out.println("ОШИБКА: недостаточно средств");
                return;
            }

            double fee = amount * 0.015;

//            from.withdraw(amount + fee);
//            to.deposit(amount);

            System.out.println("Перевод " + amount + " от " + fromId + " к " + toId + ". Комиссия: " + fee);
            System.out.println("SMS: перевод выполнен успешно");
        }

        public void printAccounts() {
            System.out.println("Текущие балансы:");
            for (BadAccount acc : accounts.values()) {
                System.out.println(acc.getId() + " -> " + acc.getBalance());
            }
        }

        public void exportToCsv(String fileName) {
            System.out.println("Экспорт аккаунтов в CSV-файл: " + fileName);
        }

        public void sendPromotionalEmails(String message) {
            System.out.println("Рассылка рекламных писем с текстом: " + message);
        }
    }

    public static void main(String[] args) {

        BankService bank = new BankService();
        // Регистрируем обычный и VIP аккаунты
        bank.registerAccount("regular", 500.0, false);
        bank.registerAccount("vip", 1000.0, true);

        // Выполняем перевод: VIP отправляет 300 обычному
        bank.transfer("vip", "regular", 300.0);

        // Смотрим балансы
        Export print = new PrintAccounts(bank.getAccounts());
        print.export("");

        Export csv = new ExportToCsv();
        csv.export("export csv");

        Export email = new SendPromotionalEmails();
        email.export("send email");
    }
}
