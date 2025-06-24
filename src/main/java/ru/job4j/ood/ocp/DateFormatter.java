package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.formatter.DateTimeParser;

import java.util.Calendar;

public class DateFormatter implements DateTimeParser<String> {
    @Override
    public String parse(String s) {
        String delimiter = ";";
        return s.replace("/", delimiter);
    }
}
