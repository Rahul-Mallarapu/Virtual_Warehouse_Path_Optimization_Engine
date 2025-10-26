package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping
    public Route addRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    @GetMapping("/shortest")
    public Map<String, Double> getShortestPath(@RequestParam String start, @RequestParam String end) {
        return routeService.calculateShortestPath(start, end);
    }
}

