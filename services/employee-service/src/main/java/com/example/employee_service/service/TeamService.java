package com.example.employee_service.service;

import com.example.employee_service.model.Team;
import com.example.employee_service.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    // Create new Team
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    // Read Team by id
    public Team readTeamById(Integer id) {
        Optional<Team> team = teamRepository.findById(id);
        return team.orElse(null);
    }

    // Read Team by id
    public Team readTeamByManagerId(Integer managerId) {
        Optional<Team> team = teamRepository.findByManagerId(managerId);
        return team.orElse(null);
    }
}
