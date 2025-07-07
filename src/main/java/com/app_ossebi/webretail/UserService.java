package com.app_ossebi.webretail;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing user-related business logic.
 * Handles operations such as creating, retrieving, and managing users.
 */
@Service
public class UserService {

    private long id = 0L;
    private final List<User> userList = new ArrayList<>();

    /**
     * Retrieves all users currently stored in the system.
     *
     * @return A list containing all users
     */
    public List<User> fetchAllUsers() {
        return userList;
    }

    /**
     * Creates a new user and adds them to the system.
     * Automatically assigns a new ID to the user before saving.
     *
     * @param user The user object to be created
     */
    public void createUser(User user) {
        user.setId(id++);
        userList.add(user);
    }

    /**
     * Finds a user by their unique identifier.
     *
     * @param id The ID of the user to find
     * @return The found user, or a new empty User object if not found
     */
    public User fetchUserById(long id) {
        User fetchedUser = new User();
        for (User user : userList) {
            if (user.getId() == id) {
                fetchedUser = user;
            }
        }
        return fetchedUser;
    }
}
