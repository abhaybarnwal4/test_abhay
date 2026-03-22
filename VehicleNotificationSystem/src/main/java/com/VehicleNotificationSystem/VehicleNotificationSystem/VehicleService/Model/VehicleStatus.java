package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model;

// model/enums/VehicleStatus.java
public enum VehicleStatus {
    ACTIVE,    // vehicle is registered and operational
    INACTIVE,  // vehicle is deregistered or parked/suspended
    RECALLED,  // vehicle is under a manufacturer or safety recall
    STOLEN,    // reported stolen — block all normal notifications
    SCRAPPED   // end-of-life, no longer in service
}