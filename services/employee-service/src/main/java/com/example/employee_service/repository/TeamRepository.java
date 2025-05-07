package com.example.employee_service.repository;

import com.example.employee_service.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    // Read Team by Manager's id
    Optional<Team> findByManagerId(Integer managerId);

}