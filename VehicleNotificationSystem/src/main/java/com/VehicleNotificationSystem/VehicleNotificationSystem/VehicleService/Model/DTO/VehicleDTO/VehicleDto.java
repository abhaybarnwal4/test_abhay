package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Model.DTO.VehicleDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDto {

    private String vehicleId;
    private String make;
    private String model;
    private String ownerId;
    private String status;
}
