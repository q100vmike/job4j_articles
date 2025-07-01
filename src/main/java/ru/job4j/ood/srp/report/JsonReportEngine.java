package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private final Store store;
    private Gson library;

    public JsonReportEngine(Store store) {
        this.store = store;
        library = new GsonBuilder().setPrettyPrinting().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return library.toJson(store.findBy(filter));
    }
}
