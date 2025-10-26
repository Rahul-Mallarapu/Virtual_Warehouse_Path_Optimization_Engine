package com.example.godown_project;

import jakarta.persistence.*;

@Entity
@Table(name = "location_nodes")
public class LocationNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    private String name;
    private String type;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;
    private String neighborCodes;

    public LocationNode() {}

    public LocationNode(String code, String name, String type,
                        double xCoordinate, double yCoordinate,
                        double zCoordinate, String neighborCodes) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
        this.neighborCodes = neighborCodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public String getNeighborCodes() {
        return neighborCodes;
    }

    public void setNeighborCodes(String neighborCodes) {
        this.neighborCodes = neighborCodes;
    }
}

