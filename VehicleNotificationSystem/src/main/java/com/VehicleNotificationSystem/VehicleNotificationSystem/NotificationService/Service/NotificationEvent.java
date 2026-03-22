package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service;


import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.Entity.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationEvent {

    private String vehicleId;
    private EventType eventType;
    private String severityLevel;
    private String message;

    // Default constructor
    public NotificationEvent() {
    }

    // Parameterized constructor
    public NotificationEvent(String vehicleId, String eventType, String severityLevel, String message) {
        this.vehicleId = vehicleId;
        this.eventType = eventType;
        this.severityLevel = severityLevel;
        this.message = message;
    }
}
