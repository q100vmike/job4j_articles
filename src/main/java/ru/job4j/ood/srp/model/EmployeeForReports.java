package ru.job4j.ood.srp.model;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

@XmlType(propOrder = {"name", "hired", "fired", "salary"})
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

    public void setName(String name) {
        this.name = name;
    }

    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getFired() {
        return fired;
    }

    public void setFired(String fired) {
        this.fired = fired;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "EmployeeForReports{"
                + "name='" + getName() + '\''
                + ", hired='" + getHired() + '\''
                + ", fired='" + getFired() + '\''
                + ", salary='" + getSalary() + '\''
                + '}';
    }

    @XmlRootElement(name = "employees")
    public static class Employees {

        private List<EmployeeForReports> employee;

        public List<EmployeeForReports> getEmployee() {
            return employee;
        }

        public void setEmployee(List<EmployeeForReports> employees) {
            this.employee = employees;
        }

        public Employees() {
        }

        public Employees(List<Employee> list) {
            DateTimeParser<Calendar> parser = new ReportDateTimeParser();
            employee = new ArrayList<>();

            list.stream()
                    .forEach(e -> employee.add(new EmployeeForReports(e.getName(),
                            parser.parse(e.getHired()),
                            parser.parse(e.getFired()),
                            Double.toString(e.getSalary()))));
        }
    }
}
