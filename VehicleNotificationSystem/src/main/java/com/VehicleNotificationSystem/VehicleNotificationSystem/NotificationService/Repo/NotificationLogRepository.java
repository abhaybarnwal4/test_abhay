package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Repo;

import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Entity.NotificationLog;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.NotificationStatus;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.SeverityLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLogRepository extends JpaRepository<NotificationLog, String> {
    List<NotificationLog> findByVehicleIdOrderBySentAtDesc(String vehicleId);
    List<NotificationLog> findBySeverityAndStatus(SeverityLevel severity, NotificationStatus status);
}