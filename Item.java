package com.example.godown_project;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @SequenceGenerator(name = "item_seq", sequenceName = "item_seq", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    private Long itemId;
    @Column(nullable = false)
    private String name;
    private String category;
    private int quantity;
    private String description;
    private double weight;

    private LocalDate arrivalDate;
    private LocalDate expiryDate;

    // This refers to the node name or ID in the warehouse graph
    @Column(nullable = false)
    private String locationCode;

    private int priority;
    private String status;
    private LocalDate creationTime = LocalDate.now();

    // 🔹 Constructors
    public Item() {}

    public Item(String name, String category, int quantity, String description,
                double weight, LocalDate arrivalDate, LocalDate expiryDate,
                String locationCode, int priority, String status) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.description = description;
        this.weight = weight;
        this.arrivalDate = arrivalDate;
        this.expiryDate = expiryDate;
        this.locationCode = locationCode;
        this.priority = priority;
        this.status = status;
    }

    // 🔹 Getters and Setters
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDate creationTime) {
        this.creationTime = creationTime;
    }
}
