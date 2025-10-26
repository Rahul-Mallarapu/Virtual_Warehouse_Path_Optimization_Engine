package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping
    public LocationNode addLocation(@RequestBody LocationNode node) {
        return locationService.saveLocation(node);
    }

    @GetMapping("/{code}")
    public LocationNode getLocation(@PathVariable String code) {
        return locationService.getLocationByCode(code);
    }

    @PutMapping("/{code}")
    public LocationNode updateLocation(@PathVariable String code, @RequestBody LocationNode node) {
        return locationService.updateLocation(code, node);
    }

    @DeleteMapping("/{code}")
    public String deleteLocation(@PathVariable String code) {
        locationService.deleteLocation(code);
        return "Location deleted successfully";
    }

    @PostMapping("/{code}/link")
    public LocationNode linkNeighbors(@PathVariable String code, @RequestBody List<String> neighborCodes) {
        return locationService.linkNeighbors(code, neighborCodes);
    }
}
