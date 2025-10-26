package com.example.godown_project;

import com.example.godown_project.WarehouseGraph;
import com.example.godown_project.WarehouseGraphRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DFS_Service {

    private final WarehouseGraphRepository warehouseGraphRepository;

    public DFS_Service(WarehouseGraphRepository warehouseGraphRepository) {
        this.warehouseGraphRepository = warehouseGraphRepository;
    }

    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) dfsHelper(neighbor, adj, vis, res);
        }
    }

    public List<String> dfsTraversal(String graphName) {
        WarehouseGraph graph = warehouseGraphRepository.findByGraphName(graphName)
                .orElseThrow(() -> new RuntimeException("Graph not found"));

        Map<String, List<String>> adjMap = GraphUtils.parseAdjacencyData(graph.getAdjacencyData());
        List<String> nodes = new ArrayList<>(adjMap.keySet());
        int V = nodes.size();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (String neighbor : adjMap.get(nodes.get(i))) {
                adj.get(i).add(nodes.indexOf(neighbor));
            }
        }

        boolean[] vis = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfsHelper(0, adj, vis, res);

        List<String> resultNodes = new ArrayList<>();
        for (int idx : res) resultNodes.add(nodes.get(idx));
        return resultNodes;
    }
}
