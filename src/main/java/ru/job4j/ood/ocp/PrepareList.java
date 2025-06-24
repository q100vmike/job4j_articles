package ru.job4j.ood.ocp;

import ru.job4j.ood.srp.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PrepareList {

    private static class SubList {
        public List<Integer> getPositiveList(ArrayList<Integer> list) {
            return list.stream().filter(x -> x > 0).toList();
        }
    }

    private static class AbstractSubList<T> {
        public List<T> getSubList(List<T> list, Predicate<T> filter) {
            return list.stream().filter(filter).toList();
        }
    }
}
