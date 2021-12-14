package model;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

public class Employee {
    String name;
    boolean weekendAvailability;
    boolean defaultAvailability;
    DayOfWeek specificDay;
    Set<Integer> monthDays;

    public Employee(String name, boolean weekendAvailability, boolean defaultAvailability, DayOfWeek specificDay, Set<Integer> monthDays) {
        this.name = name;
        this.weekendAvailability = weekendAvailability;
        this.defaultAvailability = defaultAvailability;
        this.specificDay = specificDay;
        this.monthDays = monthDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWeekendAvailability() {
        return weekendAvailability;
    }

    public void setWeekendAvailability(boolean weekendAvailability) {
        this.weekendAvailability = weekendAvailability;
    }

    public boolean isDefaultAvailability() {
        return defaultAvailability;
    }

    public void setDefaultAvailability(boolean defaultAvailability) {
        this.defaultAvailability = defaultAvailability;
    }

    public DayOfWeek getSpecificDay() {
        return specificDay;
    }

    public void setSpecificDay(DayOfWeek specificDay) {
        this.specificDay = specificDay;
    }

    public Set<Integer> getMonthDays() {
        return monthDays;
    }

    public void setMonthDays(Set<Integer> monthDays) {
        this.monthDays = monthDays;
    }

    private boolean weekendDisponibility(DayOfWeek dayOfWeek) {
        boolean response = false;
        if (dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            response = isWeekendAvailability();
        }
        return response;
    }

    private boolean weekDisponibility(DayOfWeek dayOfWeek) {
        boolean response = false;
        if (!dayOfWeek.equals(DayOfWeek.SATURDAY) && !dayOfWeek.equals(DayOfWeek.SUNDAY)) {
            response = isDefaultAvailability();
        }
        return response;
    }

    public boolean isAvailable(LocalDate assignmentDay) {
        DayOfWeek dayOfWeek = assignmentDay.getDayOfWeek();
        return dayOfWeek.equals(specificDay) || weekendDisponibility(dayOfWeek) || weekDisponibility(dayOfWeek) || monthDays.contains(assignmentDay.getDayOfMonth());
    }
}
