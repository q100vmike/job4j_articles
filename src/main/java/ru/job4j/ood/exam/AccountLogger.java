package ru.job4j.ood.exam;

public class AccountLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }

    @Override
    public void errorNoMoneyLog() {
        System.out.println("ОШИБКА: недостаточно средств");
    }

    @Override
    public void successLog() {
        System.out.println("SMS: перевод выполнен успешно");
    }

    @Override
    public void errorNofLog() {
        System.out.println("ОШИБКА: аккаунт не найден");
    }

}
