package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Calendar;
import java.util.GregorianCalendar;

class JsonReportEngineTest {

    @Test
    void whenJsonReportGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar now = Calendar.getInstance();

        Calendar data1 = new GregorianCalendar(2017, Calendar.JANUARY, 25);
        Calendar data2 = new GregorianCalendar(2025, Calendar.MAY, 10);

        Employee employee = new Employee("John Doe",
                now,
                now,
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                now,
                now,
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new JsonReportEngine(store);
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 5000.0
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "08:06:2023 17:41",
                    "fired": "08:06:2023 17:41",
                    "salary": 6000.0
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
        }
}