package com.example.godown_project;

import com.example.godown_project.WarehouseGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface WarehouseGraphRepository extends JpaRepository<WarehouseGraph, Long> {
    Optional<WarehouseGraph> findByGraphName(String graphName);
}