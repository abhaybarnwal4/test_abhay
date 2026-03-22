package com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Controller;



import com.VehicleNotificationSystem.VehicleNotificationSystem.Entity.User;
import com.VehicleNotificationSystem.VehicleNotificationSystem.UserService.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // ✅ Create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    // ✅ Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // ✅ Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // ✅ Update User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id,
                                           @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    // ✅ Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}