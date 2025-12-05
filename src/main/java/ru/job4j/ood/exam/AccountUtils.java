package ru.job4j.ood.exam;

public class AccountUtils {

        public static double withdraw(double balance, double amount) {
            return balance - amount;
        }

         public static double deposit(double balance, double amount) {
            return balance + amount;
        }
}
