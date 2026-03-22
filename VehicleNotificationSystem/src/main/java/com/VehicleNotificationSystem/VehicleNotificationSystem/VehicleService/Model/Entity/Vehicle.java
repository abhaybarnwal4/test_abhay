package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.Entity;

import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.VehicleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle {
    @Id
    private String vehicleId;           // e.g. "VH-9021"
    private String make;
    private String model;
    private String ownerId;             // FK to User
    @Enumerated(EnumType.STRING)
    private VehicleStatus status;       // ACTIVE, INACTIVE, RECALLED
    private LocalDateTime registeredAt;
    // getters / setters
}