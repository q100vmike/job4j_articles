package ru.job4j.ood.srp.model;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class EmployeeForReports {

    private String name;
    private String hired;
    private String fired;
    private String salary;

    public EmployeeForReports(String name, String hired, String fired, String salary) {
        this.name = name;
        this.hired = hired;
        this.fired = fired;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getHired() {
        return hired;
    }

    public String getFired() {
        return fired;
    }

    public String getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeForReports that = (EmployeeForReports) o;
        return Objects.equals(salary, that.salary) && Objects.equals(name, that.name) && Objects.equals(hired, that.hired) && Objects.equals(fired, that.fired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hired, fired, salary);
    }

    @XmlRootElement(name = "employees")
    public static class Employees {

        private List<EmployeeForReports> employees;

        public List<EmployeeForReports> getEmployees() {
            return employees;
        }

        public void setEmployees(List<EmployeeForReports> employees) {
            this.employees = employees;
        }

        public Employees() {
        }

        public Employees(List<Employee> employee) {
            DateTimeParser<Calendar> parser = new ReportDateTimeParser();
            employees = new ArrayList<>();

            employees.add(new EmployeeForReports("1",
                    "1",
                    "3",
                    "4"));
            employees.add(new EmployeeForReports("2",
                    "2",
                    "3",
                    "4"));
            employees.add(new EmployeeForReports("3",
                    "3",
                    "3",
                    "4"));

            /*
            employee.stream()
                    .forEach(e -> employees.add(new EmployeeForReports(e.getName(),
                            parser.parse(e.getHired()),
                            parser.parse(e.getFired()),
                            e.getSalary()))); */
        }
    }
}
