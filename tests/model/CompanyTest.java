package model;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    void teamsAvailables() {
        LocalDate assignmentDay = LocalDate.of(2021, 12, 22);
        Company company = new Company("10Pines");
        Team teamRed = new Team();
        teamRed.addMemberToTeam(new Employee("Margarita",true,false, DayOfWeek.WEDNESDAY, Set.of()));
        teamRed.addMemberToTeam(new Employee("Jazmín",false,true,null,Set.of()));
        teamRed.addMemberToTeam(new Employee("Fanny",false,false,DayOfWeek.THURSDAY,Set.of(2,3,5,7,20,21,22,23,24,25,26,27,28)));
        teamRed.addMemberToTeam(new Employee("Benicio",false,false,DayOfWeek.THURSDAY,Set.of(2,3,5,7,20,21,22,23,24,25,26,27,28)));

        Team teamBlue = new Team();
        teamBlue.addMemberToTeam(new Employee("Gregorio",true,false,null,Set.of()));
        teamBlue.addMemberToTeam(new Employee("Esteban",true,false,null,Set.of()));

        company.setTeams(Set.of(teamRed, teamBlue));
        Set<Team> teamsAvailables = company.teamsAvailables(assignmentDay);
        assertEquals(1,teamsAvailables.size());
    }
}