package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service;

import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.EventType;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.SeverityLevel;
import org.springframework.stereotype.Service;

@Service
public class SeverityRouter {
    public SeverityLevel resolve(EventType eventType, String severityOverride) {
        if (severityOverride != null && !severityOverride.isBlank()) {
            return SeverityLevel.fromString(severityOverride);
        }
        return eventType.defaultSeverity();
    }
}