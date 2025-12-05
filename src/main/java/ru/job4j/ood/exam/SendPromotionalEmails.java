package ru.job4j.ood.exam;

public class SendPromotionalEmails implements Export {
    @Override
    public void export(String message) {
        System.out.println("Рассылка рекламных писем с текстом: " + message);
    }
}
