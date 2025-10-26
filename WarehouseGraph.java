package com.example.godown_project;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "warehouse_graph")
public class WarehouseGraph {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String graphName; // e.g., "Main Warehouse Graph"

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String adjacencyData; // JSON data: {"A1":["A2","A3"],"A2":["B1"],...}

    private int totalNodes;
    private int totalEdges;

    private LocalDateTime lastUpdated = LocalDateTime.now();

    public WarehouseGraph() {}

    public WarehouseGraph(String graphName, String adjacencyData, int totalNodes, int totalEdges) {
        this.graphName = graphName;
        this.adjacencyData = adjacencyData;
        this.totalNodes = totalNodes;
        this.totalEdges = totalEdges;
        this.lastUpdated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGraphName() {
        return graphName;
    }

    public void setGraphName(String graphName) {
        this.graphName = graphName;
    }

    public String getAdjacencyData() {
        return adjacencyData;
    }

    public void setAdjacencyData(String adjacencyData) {
        this.adjacencyData = adjacencyData;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public int getTotalEdges() {
        return totalEdges;
    }

    public void setTotalEdges(int totalEdges) {
        this.totalEdges = totalEdges;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}

