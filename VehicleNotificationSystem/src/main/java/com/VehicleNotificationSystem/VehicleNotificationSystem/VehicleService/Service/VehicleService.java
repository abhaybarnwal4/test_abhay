package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Service;

import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Exception.VehicleNotFoundException;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.DTO.VehicleDTO.VehicleDto;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.Entity.Vehicle;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.VehicleStatus;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Repo.VehicleRepository;
import org.springframework.stereotype.Service;


@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehicleDto getByVehicleId(String vehicleId) {
        Vehicle v = vehicleRepository.findByVehicleId(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found: " + vehicleId));
        return toDto(v);
    }

    public boolean isActive(String vehicleId) {
        return vehicleRepository.existsByVehicleIdAndStatus(vehicleId, VehicleStatus.ACTIVE);
    }

    private VehicleDto toDto(Vehicle v) {
        VehicleDto dto = new VehicleDto();
        dto.setVehicleId(v.getVehicleId());
        dto.setMake(v.getMake());
        dto.setModel(v.getModel());
        dto.setOwnerId(v.getOwnerId());
        dto.setStatus(v.getStatus().name());
        return dto;
    }
}