package com.example.godown_project;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StorageAlgorithmService {

    private final LocationService locationService;

    public StorageAlgorithmService(LocationService locationService) {
        this.locationService = locationService;
    }

    public String suggestLocation(Item item) {
        List<LocationNode> allNodes = locationService.getAllLocations();
        // Example: simple priority-based assignment
        allNodes.sort((a, b) -> Double.compare(a.getxCoordinate(), b.getxCoordinate()));
        return allNodes.isEmpty() ? null : allNodes.get(0).getCode();
    }
}

