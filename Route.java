package com.example.godown_project;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String startLocationCode;

    @Column(nullable = false)
    private String endLocationCode;

    private double distance;

    @Column(length = 2000)
    private String path;

    public Route() {}

    public Route(String startLocationCode, String endLocationCode, double distance, String path) {
        this.startLocationCode = startLocationCode;
        this.endLocationCode = endLocationCode;
        this.distance = distance;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartLocationCode() {
        return startLocationCode;
    }

    public void setStartLocationCode(String startLocationCode) {
        this.startLocationCode = startLocationCode;
    }

    public String getEndLocationCode() {
        return endLocationCode;
    }

    public void setEndLocationCode(String endLocationCode) {
        this.endLocationCode = endLocationCode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
