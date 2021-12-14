package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Company {
    String name;
    Set<Team> teams;

    public Company(String name) {
        this.name = name;
        this.teams = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Team> teamsAvailables(LocalDate assignmentDay) {
        return teams.stream().filter(team -> team.checkGroupAvailability(assignmentDay)).collect(Collectors.toSet());
    }
}
