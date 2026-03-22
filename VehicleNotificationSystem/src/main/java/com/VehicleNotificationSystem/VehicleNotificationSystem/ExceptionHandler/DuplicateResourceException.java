package com.VehicleNotificationSystem.VehicleNotificationSystem.ExceptionHandler;

public class DuplicateResourceException extends  RuntimeException{

    public DuplicateResourceException(String message) {
        super(message);
    }
}
