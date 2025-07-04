package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.EmployeeForReports;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.function.Predicate;

public class XMLReportEngine implements Report {
    private JAXBContext context;
    private Marshaller marshaller;
    private final Store store;

    public XMLReportEngine(Store store) throws JAXBException {
        this.store = store;
        context = JAXBContext.newInstance(Employee.Emps.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        try (StringWriter writer = new StringWriter()) {

            EmployeeForReports.Employees employees = new EmployeeForReports.Employees(store.findBy(filter));

            Employee.Emps empl = new Employee.Emps(store.findBy(filter));

            //marshaller.marshal(employees, writer);
            marshaller.marshal(empl, writer);

            xml = writer.getBuffer().toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return xml;
    }
}
