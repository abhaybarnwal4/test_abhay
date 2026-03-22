package com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Service;

import com.VehicleNotificationSystem.VehicleNotificationSystem.Entity.User;
import com.VehicleNotificationSystem.VehicleNotificationSystem.ExceptionHandler.DuplicateResourceException;
import com.VehicleNotificationSystem.VehicleNotificationSystem.ExceptionHandler.ResourceNotFoundException;
import com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("Email already registered: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
              .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(UUID id, User updatedUser) {
        User existing = getUserById(id);
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setPhone(updatedUser.getPhone());
       // existing.setNotificationPreference(updatedUser.getNotificationPreference());
        return userRepository.save(existing);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
