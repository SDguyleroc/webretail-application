package com.app_ossebi.webretail;

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
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    /**
     * Creates a new user with the provided user details.
     *
     * @param user The user object containing user details
     * @return A success message indicating the user was created
     */
    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User created successfully";
    }

    /**
     * Retrieves a specific user by their ID.
     *
     * @param id The ID of the user to retrieve
     * @return The user with the specified ID, or null if not found
     */
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.fetchUserById(id);
    }
}
