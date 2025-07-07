package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Calendar;
import java.util.GregorianCalendar;

class JsonReportEngineTest {

    @Test
    void whenJsonReportGenerated() {
        MemoryStore store = new MemoryStore();
        Calendar data1 = new GregorianCalendar(2017, Calendar.JANUARY, 25, 15, 14, 30);
        Calendar data2 = new GregorianCalendar(2018, Calendar.DECEMBER, 10,16, 14, 30);
        Calendar data3 = new GregorianCalendar(2019, Calendar.FEBRUARY, 20,17, 14, 30);
        Calendar data4 = new GregorianCalendar(2020, Calendar.MAY, 11,18, 14, 30);
        Employee employee = new Employee("John Doe",
                data1,
                data2,
                5000.0);
        Employee employee1 = new Employee("Jane Smith",
                data3,
                data4,
                6000.0);
        store.add(employee);
        store.add(employee1);
        Report engine = new JsonReportEngine(store);
        String ex = """
                [
                  {
                    "name": "John Doe",
                    "hired": "25:01:2017 15:14",
                    "fired": "10:12:2018 16:14",
                    "salary": "5000.0"
                  },
                  {
                    "name": "Jane Smith",
                    "hired": "20:02:2019 17:14",
                    "fired": "11:05:2020 18:14",
                    "salary": "6000.0"
                  }
                ]""";
        assertThat(engine.generate(em -> true)).isEqualTo(ex);
        }
}