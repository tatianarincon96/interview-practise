package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Employee> employees;

    public Team() {
        this.employees = new ArrayList<>();
    }

    public void addMemberToTeam(Employee employee) {
        employees.add(employee);
    }

    public void removeMemberToTeam(Employee employee) {
        employees.remove(employee);
    }

    public boolean checkGroupAvailability(LocalDate assignmentDay) {
       return employees.stream().allMatch(employee -> employee.isAvailable(assignmentDay));
    }
}
