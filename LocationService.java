package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Save a new location node
    public LocationNode saveLocation(LocationNode node) {
        return locationRepository.save(node);
    }

    // Get a location node by its code
    public LocationNode getLocationByCode(String code) {
        return locationRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Location not found with code: " + code));
    }

    // Update an existing location
    public LocationNode updateLocation(String code, LocationNode updatedNode) {
        LocationNode existingNode = getLocationByCode(code);

        existingNode.setName(updatedNode.getName());
        existingNode.setType(updatedNode.getType());
        existingNode.setxCoordinate(updatedNode.getxCoordinate());
        existingNode.setyCoordinate(updatedNode.getyCoordinate());
        existingNode.setzCoordinate(updatedNode.getzCoordinate());
        existingNode.setNeighborCodes(updatedNode.getNeighborCodes());

        return locationRepository.save(existingNode);
    }

    // Delete a location node
    public void deleteLocation(String code) {
        LocationNode existingNode = getLocationByCode(code);
        locationRepository.delete(existingNode);
    }

    // Link neighbors to a location node
    public LocationNode linkNeighbors(String code, List<String> neighborCodes) {
        LocationNode node = getLocationByCode(code);
        node.setNeighborCodes(String.join(",", neighborCodes));
        return locationRepository.save(node);
    }
}


