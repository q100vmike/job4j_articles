package ru.job4j.ood.srp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewCarNumber {

    public List<String> numbers;

    public void generateCarNumber() {
        Random random = new Random();
        numbers.add("АМР" + random.nextInt() + "111");
    }
}
