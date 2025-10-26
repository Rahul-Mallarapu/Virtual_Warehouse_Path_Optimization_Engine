package com.example.godown_project;

import com.example.godown_project.WarehouseGraph;
import com.example.godown_project.WarehouseGraphRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Dijkstra_Service {

    private final WarehouseGraphRepository warehouseGraphRepository;

    public Dijkstra_Service(WarehouseGraphRepository warehouseGraphRepository) {
        this.warehouseGraphRepository = warehouseGraphRepository;
    }

    public Map<String, Double> dijkstra(String graphName, String startNode) {
        WarehouseGraph graph = warehouseGraphRepository.findByGraphName(graphName)
                .orElseThrow(() -> new RuntimeException("Graph not found"));

        Map<String, List<String>> adjMap = GraphUtils.parseAdjacencyData(graph.getAdjacencyData());
        List<String> nodes = new ArrayList<>(adjMap.keySet());
        int V = nodes.size();
        int startIdx = nodes.indexOf(startNode);

        double[] dist = new double[V];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[startIdx] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> dist[i]));
        pq.add(startIdx);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (String neighbor : adjMap.get(nodes.get(u))) {
                int v = nodes.indexOf(neighbor);
                double weight = 1; // assume uniform weight, can be updated if needed
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(v);
                }
            }
        }

        Map<String, Double> distances = new HashMap<>();
        for (int i = 0; i < V; i++) distances.put(nodes.get(i), dist[i]);
        return distances;
    }
}
