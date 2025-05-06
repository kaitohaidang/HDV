package com.example.employee_service.controller;

import com.example.employee_service.model.Team;
import com.example.employee_service.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public Team createEmployee(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/{id}")
    public Team getEmployeeById(@PathVariable Integer id) {
        return teamService.readTeamById(id);
    }

    @GetMapping("/manager/{managerId}")
    public Team getEmployeeByTeamId(@PathVariable Integer managerId) {
        return teamService.readTeamByManagerId(managerId);
    }
}
