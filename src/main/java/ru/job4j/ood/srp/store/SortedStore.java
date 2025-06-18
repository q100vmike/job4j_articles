package ru.job4j.ood.srp.store;

import ru.job4j.ood.srp.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SortedStore extends MemoryStore {

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        List<Employee> emp = super.findBy(filter);
        Collections.sort(emp,
                Comparator.comparing(Employee :: getSalary).reversed()
        );
        return emp;
    }
}
