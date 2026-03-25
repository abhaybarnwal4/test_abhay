package com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Dto;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    // --- Identity ---
    private String userId;
    private String username;
    private String fullName;

    // --- Contact channels (used by NotificationSender) ---
    private String email;          // sendEmail / sendPushAndEmail
    private String phoneNumber;    // sendPushAndSms  (E.164 format, e.g. +919876543210)
    private String fcmToken;       // sendPush / sendPushAndSms / sendPushAndEmail

    // --- Optional metadata ---
    private String role;           // e.g. "OWNER", "DRIVER", "FLEET_MANAGER"
    private boolean active;        // guard: skip notification if account is inactive
}