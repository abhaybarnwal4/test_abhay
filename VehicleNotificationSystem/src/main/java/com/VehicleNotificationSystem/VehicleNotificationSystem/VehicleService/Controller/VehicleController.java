package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Controller;

import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.DTO.VehicleDTO.VehicleDto;
import com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDto> getVehicle(@PathVariable String vehicleId) {
        return ResponseEntity.ok(vehicleService.getByVehicleId(vehicleId));
    }

    @GetMapping("/{vehicleId}/active")
    public ResponseEntity<Map<String, Boolean>> isActive(@PathVariable String vehicleId) {
        return ResponseEntity.ok(Map.of("active", vehicleService.isActive(vehicleId)));
    }
}