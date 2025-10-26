package com.example.godown_project;

import com.example.godown_project.WarehouseGraph;
import com.example.godown_project.WarehouseGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopologicalSortService {

    @Autowired
    private WarehouseGraphRepository warehouseGraphRepository;

    public TopologicalSortService(WarehouseGraphRepository warehouseGraphRepository) {
        this.warehouseGraphRepository = warehouseGraphRepository;
    }

    public List<String> topoSort(String graphName) {
        WarehouseGraph graph = warehouseGraphRepository.findByGraphName(graphName)
                .orElseThrow(() -> new RuntimeException("Graph not found"));

        Map<String, List<String>> adjMap = GraphUtils.parseAdjacencyData(graph.getAdjacencyData());
        List<String> nodes = new ArrayList<>(adjMap.keySet());
        int V = nodes.size();

        int[] indegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (String neighbor : adjMap.get(nodes.get(i))) {
                int j = nodes.indexOf(neighbor);
                adj.get(i).add(j);
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indegree[i] == 0) q.add(i);

        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            order.add(node);
            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.add(neighbor);
            }
        }

        List<String> resultNodes = new ArrayList<>();
        for (int idx : order) resultNodes.add(nodes.get(idx));
        return resultNodes;
    }
}
