import model.Employee;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void isAvailableDayOfMonth() {
        LocalDate assignmentDay = LocalDate.of(2022, 1, 2);
        Employee employee = new Employee("Lola",false,false,null,Set.of(2,3));
        assertTrue(employee.isAvailable(assignmentDay));
    }

    @Test
    void isAvailableSpecificDay() {
        LocalDate assignmentDay = LocalDate.of(2022, 1, 2);
        Employee employee = new Employee("Lola",false,false,DayOfWeek.SUNDAY,Set.of());
        assertTrue(employee.isAvailable(assignmentDay));
    }

    @Test
    void isAvailableOnWeekend() {
        LocalDate assignmentDay = LocalDate.of(2022, 1, 2);
        Employee employee = new Employee("Lola",true,false,null,Set.of());
        assertTrue(employee.isAvailable(assignmentDay));
    }

    @Test
    void isAvailableDefaultDays() {
        LocalDate assignmentDay = LocalDate.of(2021, 12, 14);
        Employee employee = new Employee("Lola",false,true,null,Set.of());
        assertTrue(employee.isAvailable(assignmentDay));
    }

    @Test
    void isNotAvailable() {
        LocalDate assignmentDay = LocalDate.of(2021, 12, 13);
        Employee employee = new Employee("Lola",false,false,DayOfWeek.THURSDAY,Set.of(2,3));
        assertFalse(employee.isAvailable(assignmentDay));
    }
}