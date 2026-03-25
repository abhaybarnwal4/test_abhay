package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Entity;


import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.EventType;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.NotificationChannel;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.NotificationStatus;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.SeverityLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "notification_log")
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String vehicleId;
    private String userId;
    @Enumerated(EnumType.STRING) private EventType eventType;
    @Enumerated(EnumType.STRING) private SeverityLevel severity;
    @Enumerated(EnumType.STRING) private NotificationChannel channel; // PUSH, SMS, EMAIL
    @Enumerated(EnumType.STRING) private NotificationStatus status;   // SENT, FAILED
    private String message;
    private LocalDateTime sentAt;
    // getters / setters
}