package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service;


import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.EventType;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.SeverityLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class NotificationEvent {

    private String vehicleId;
    private EventType eventType;
    private SeverityLevel severityLevel;
    private String message;

    // Default constructor
    public NotificationEvent() {
    }

    // Parameterized constructor
    public NotificationEvent(String vehicleId, EventType eventType, SeverityLevel severityLevel, String message) {
        this.vehicleId = vehicleId;
        this.eventType = eventType;
        this.severityLevel = severityLevel;
        this.message = message;
    }
}
