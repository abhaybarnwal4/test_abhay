package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum;

public enum SeverityLevel {

    LOW, MEDIUM, HIGH, CRITICAL;

    public static SeverityLevel fromString(String value) {
        if (value == null) return LOW;
        try { return valueOf(value.toUpperCase()); }
        catch (IllegalArgumentException e) { return LOW; }
    }
}


