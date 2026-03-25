package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Controller;

import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Entity.Dto.NotificationRequest;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.SeverityLevel;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service.NotificationEvent;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service.NotificationSender;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service.SeverityRouter;
import com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationSender notificationSender;
    private final SeverityRouter severityRouter;

    public NotificationController(NotificationSender notificationSender,
                                  SeverityRouter severityRouter) {
        this.notificationSender = notificationSender;
        this.severityRouter = severityRouter;
    }

    /**
     * POST /api/notifications/send
     * Resolves severity (override or default from EventType),
     * builds the event, and dispatches via NotificationSender.
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(
            @RequestBody NotificationRequest request) {

        // 1. Resolve severity — honour override, else use EventType default
        SeverityLevel severity = severityRouter.resolve(
                request.getEventType(),
                request.getSeverityOverride()
        );

        // 2. Build the event
        NotificationEvent event = new NotificationEvent(
                request.getVehicleId(),
                request.getEventType(),
                severity,
                request.getMessage()
        );

        // 3. Build the user (in a real system, look this up from UserService)
        UserDto user = new UserDto();
        user.setUserId(request.getUserId());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setFcmToken(request.getFcmToken());
        user.setActive(true);

        // 4. Send
        notificationSender.send(event, user);

        return ResponseEntity.ok("Notification dispatched successfully " +
                "[severity=" + severity + ", channel routed by NotificationSender]");
    }
}