package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Entity.Dto;

import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.EventType;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public  class NotificationRequest {

    // Vehicle context
    private String vehicleId;

    // Event details
    private EventType eventType;
    private String message;

    // Optional — if null/blank, SeverityRouter uses EventType.defaultSeverity()
    private String severityOverride;

    // User identity & contact info
    private String  userId;
    private String email;
    private String phoneNumber;
    private String fcmToken;
}

