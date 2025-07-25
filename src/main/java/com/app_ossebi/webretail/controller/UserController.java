package com.app_ossebi.webretail.controller;

import com.app_ossebi.webretail.dto.UserRequest;
import com.app_ossebi.webretail.dto.UserRespond;
import com.app_ossebi.webretail.service.UserService;
import com.app_ossebi.webretail.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * REST Controller for handling user-related HTTP requests.
 * All endpoints are prefixed with "/api".
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves all users from the system.
     *
     * @return List of all users
     */
    @GetMapping("/users")
    public ResponseEntity<List<UserRespond>> getAllUsers() {
        if (userService.fetchAllUsers().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        // Retrieve all users
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    /**
     * Creates a new user with the provided user details.
     *
     * @param user The user object containing user details
     * @return A success message indicating the user was created
     */
    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserRequest user) {
        // Check if user is valid

        if(user == null){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user");
        }
        // Create the user
        userService.createUser(user);

        // Return a success message
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully: " + user);
    }

    /**
     * Retrieves a specific user by their ID.
     *
     * @param id The ID of the user to retrieve
     * @return The user with the specified ID, or null if not found
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<UserRespond> getUserById(@PathVariable int id) {

        return userService.fetchUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

//        User user = userService.fetchUserById(id);
//        if (user == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody UserRequest updatedUserRequest) {
        if (userService.updateUser(id, updatedUserRequest)) {
            return ResponseEntity.ok("User updated successfully: " + updatedUserRequest);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found: " + id);
        }
    }
}
