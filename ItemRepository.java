package com.example.godown_project;

import com.example.godown_project.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategory(String category);
    List<Item> findByLocationCode(String locationCode);
    List<Item> findByNameContainingIgnoreCase(String name);
}

