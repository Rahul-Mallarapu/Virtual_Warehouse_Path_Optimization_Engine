package com.example.godown_project;

import com.example.godown_project.LocationNode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationNode, Long> {
    Optional<LocationNode> findByCode(String code);
}
