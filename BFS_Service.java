package com.example.godown_project;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BFS_Service
{
    private final LocationRepository locationRepository;
    private final WarehouseGraphRepository warehouseGraphRepository;

    public BFS_Service(LocationRepository locationRepository,
                                 WarehouseGraphRepository warehouseGraphRepository) {
        this.locationRepository = locationRepository;
        this.warehouseGraphRepository = warehouseGraphRepository;
    }

    public List<String> bfsTraversal(String graphName, int startNodeIndex) {
        WarehouseGraph graph = warehouseGraphRepository.findByGraphName(graphName)
                .orElseThrow(() -> new RuntimeException("Graph not found"));

        // Parse adjacencyData stored as JSON string into adjacency list
        Map<String, List<String>> adjMap = GraphUtils.parseAdjacencyData(graph.getAdjacencyData());

        // Map nodes to indices
        List<String> nodes = new ArrayList<>(adjMap.keySet());
        int V = nodes.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (String neighbor : adjMap.get(nodes.get(i))) {
                int j = nodes.indexOf(neighbor);
                adj.get(i).add(j);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        visited[startNodeIndex] = true;
        q.add(startNodeIndex);

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }

        List<String> resultNodes = new ArrayList<>();
        for (int idx : result) resultNodes.add(nodes.get(idx));
        return resultNodes;
    }
}
