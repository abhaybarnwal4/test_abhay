package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Repo;

import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.Entity.Vehicle;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Optional<Vehicle> findByVehicleId(String vehicleId);
    boolean existsByVehicleIdAndStatus(String vehicleId, VehicleStatus status);
}