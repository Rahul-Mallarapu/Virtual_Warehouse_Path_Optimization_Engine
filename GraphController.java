package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/graph")
public class GraphController {

    @Autowired
    private TopologicalSortService topoService;

    @Autowired
    private BFS_Service bfsService;

    @Autowired
    private DFS_Service dfsService;

    @GetMapping("/toposort")
    public List<String> getTopologicalOrder(@RequestParam String graphName) {
        return topoService.topoSort(graphName);
    }

    @GetMapping("/bfs")
    public List<String> bfsTraversal(@RequestParam String graphName, @RequestParam int startIndex) {
        return bfsService.bfsTraversal(graphName, startIndex);
    }

    @GetMapping("/dfs")
    public List<String> dfsTraversal(@RequestParam String graphName) {
        return dfsService.dfsTraversal(graphName);
    }
}

