package com.app_ossebi.webretail;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
  private UserService userService;



    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.fetchAllUsers();
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        userService.createUser(user);
        return "User created successfully";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.fetchUserById(id);
    }

}
