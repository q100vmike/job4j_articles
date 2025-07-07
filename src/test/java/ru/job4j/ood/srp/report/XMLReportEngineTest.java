package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.GregorianCalendar;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class XMLReportEngineTest {

    @Test
    void whenXMLReportGenerated() throws JAXBException {
        MemoryStore store = new MemoryStore();
        Employee employee = new Employee("John Doe",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                new GregorianCalendar(2023, Calendar.JUNE, 8, 17, 41),
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report report = new XMLReportEngine(store);
        String expect = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employees>\n"
                + "    <employee>\n"
                + "        <name>John Doe</name>\n"
                + "        <hired>08:06:2023 17:41</hired>\n"
                + "        <fired>08:06:2023 17:41</fired>\n"
                + "        <salary>5000.0</salary>\n"
                + "    </employee>\n"
                + "    <employee>\n"
                + "        <name>Jane Smith</name>\n"
                + "        <hired>08:06:2023 17:41</hired>\n"
                + "        <fired>08:06:2023 17:41</fired>\n"
                + "        <salary>6000.0</salary>\n"
                + "    </employee>\n"
                + "</employees>\n";

        assertThat(report.generate(em -> true)).isEqualTo(expect);
    }
}