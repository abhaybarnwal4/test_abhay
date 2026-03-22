package com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Repo;

import com.VehicleNotificationSystem.VehicleNotificationSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);

   // List<User> findByNotificationPreference(NotificationPreference preference);

    boolean existsByEmail(String email);
}
