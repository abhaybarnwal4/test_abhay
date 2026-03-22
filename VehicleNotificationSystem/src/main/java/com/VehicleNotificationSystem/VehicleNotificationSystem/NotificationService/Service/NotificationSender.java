package com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Service;

import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Entity.NotificationLog;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Model.Enum.NotificationChannel;
import com.VehicleNotificationSystem.VehicleNotificationSystem.NotificationService.Repo.NotificationLogRepository;
import com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {
    private final NotificationLogRepository logRepository;

    public NotificationSender(NotificationLogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void send(NotificationEvent event, UserDto user) {
        NotificationChannel channel = switch (event.getSeverityLevel()) {
            case CRITICAL -> { sendPushAndSms(event, user);   yield NotificationChannel.PUSH_SMS; }
            case HIGH     -> { sendPushAndEmail(event, user); yield NotificationChannel.PUSH_EMAIL; }
            case MEDIUM   -> { sendPush(event, user);         yield NotificationChannel.PUSH; }
            case LOW      -> { sendEmail(event, user);        yield NotificationChannel.EMAIL; }
        };
        log(event, user, channel, NotificationStatus.SENT);
    }

    private void sendPushAndSms(NotificationEvent e, UserDto u) {
        // FCM push + SMS gateway integration point
    }
    private void sendPushAndEmail(NotificationEvent e, UserDto u) {
        // FCM push + JavaMail / SendGrid integration point
    }
    private void sendPush(NotificationEvent e, UserDto u) {
        // FCM-only push
    }
    private void sendEmail(NotificationEvent e, UserDto u) {
        // JavaMail / SendGrid only
    }

    private void log(NotificationEvent e, UserDto u,
                     NotificationChannel channel, NotificationStatus status) {
        NotificationLog log = new NotificationLog();
        log.setVehicleId(e.getVehicleId());
        log.setUserId(u.getUserId());
        log.setEventType(e.getEventType());
        log.setSeverity(e.getSeverityLevel());
        log.setChannel(channel);
        log.setStatus(status);
        log.setMessage(e.getMessage());
        log.setSentAt(LocalDateTime.now());
        logRepository.save(log);
    }
}