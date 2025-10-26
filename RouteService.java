package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private Dijkstra_Service dijkstraService;

    // Save a new route
    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }

    public Map<String, Double> calculateShortestPath(String startCode, String endCode) {
        // Use Dijkstra service to get distances from start node
        Map<String, Double> distances = dijkstraService.dijkstra("MainWarehouseGraph", startCode);

        // Optionally, you can save the distance as a Route entity
        Route route = new Route(startCode, endCode, distances.getOrDefault(endCode, Double.MAX_VALUE), null);
        routeRepository.save(route);

        return distances;
    }
}

