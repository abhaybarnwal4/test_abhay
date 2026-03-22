package com.VehicleNotificationSystem.VehicleNotificationSystem.VehicleService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle/admin")
public class VehicleAdminController {

    @GetMapping("/VehicleId")
    public String getVehicleDetails(){
        return "Vehicle";
    }

    @PostMapping("/{vehicleId}")
    public void saveVehcileDetails(){



    }
}
