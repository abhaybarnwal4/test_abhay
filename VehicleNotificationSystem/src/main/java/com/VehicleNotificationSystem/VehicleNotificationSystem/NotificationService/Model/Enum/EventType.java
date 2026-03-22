package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum;



    public enum EventType {
        CRASH_DETECTED, ENGINE_FAILURE, GEOFENCE_BREACH,
        SPEED_ALERT, BATTERY_LOW, SERVICE_DUE, UNKNOWN;

        public SeverityLevel defaultSeverity() {
            return switch (this) {
                case CRASH_DETECTED  -> SeverityLevel.CRITICAL;
                case ENGINE_FAILURE  -> SeverityLevel.HIGH;
                case GEOFENCE_BREACH -> SeverityLevel.HIGH;
                case SPEED_ALERT     -> SeverityLevel.MEDIUM;
                case BATTERY_LOW     -> SeverityLevel.MEDIUM;
                case SERVICE_DUE     -> SeverityLevel.LOW;
                default              -> SeverityLevel.LOW;
            };
        }
    }


