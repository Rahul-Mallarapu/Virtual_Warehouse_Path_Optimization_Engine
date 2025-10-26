package com.example.godown_project;

import com.example.godown_project.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findByStartLocationCodeAndEndLocationCode(String start, String end);
}
