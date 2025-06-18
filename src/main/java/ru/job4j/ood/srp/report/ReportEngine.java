package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private String header = "Name; Hired; Fired; Salary;";
    private String reportType;
    private String delimiter = " ";

    public ReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
    }

    public ReportEngine(Store store, DateTimeParser<Calendar> dateTimeParser, String header, String reportType, String delimiter) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.header = header;
        this.reportType = reportType;
        this.delimiter = delimiter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append(header)
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(delimiter)
                    .append("HR".equals(reportType) ? "" : (dateTimeParser.parse(employee.getHired())) + delimiter)
                    .append("HR".equals(reportType) ? "" : (dateTimeParser.parse(employee.getFired())) + delimiter)
                    .append(employee.getSalary())
                    .append(" ".equals(delimiter) ? "" : delimiter)
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}