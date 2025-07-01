package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employee> employees;

    public Employees() {
    }

    public Employees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getList() {
        return employees;
    }

    public void setList(List<Employee> employees) {
        this.employees = employees;
    }
}
