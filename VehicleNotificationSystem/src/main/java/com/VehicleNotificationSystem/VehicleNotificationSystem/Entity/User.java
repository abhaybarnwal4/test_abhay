package com.VehicleNotificationSystem.VehicleNotificationSystem.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phone;

    //@Enumerated(EnumType.STRING)
    //private NotificationPreference notificationPreference; // EMAIL, SMS, PUSH

    @CreationTimestamp
    private LocalDateTime createdAt;

    // getters, setters, constructors
}