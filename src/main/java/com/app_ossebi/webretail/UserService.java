package com.app_ossebi.webretail;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Optional<User> fetchUserById(long id) {

        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
//        for (User user: userList){
//            if(user.getId().equals(id)){
//                return user;
//            }
//        }
//        return null;

//        User fetchedUser = new User();
//        for (User user : userList) {
//            if (user.getId().equals(id)) {
//                fetchedUser = user;
//            }
//        }
//        return fetchedUser;

    }

    public Optional<User> updateUser(long id, User userDetails) {
        // using stream
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> {
                    user.setFirstName(userDetails.getFirstName());
                    user.setLastName(userDetails.getLastName());
                    return user;
                });


        // Update the user using the provided ID with the new user details using a for loop
//        for (User u : userList) {
//            if (u.getId().equals(id)) {
//                u.setFirstName(userDetails.getFirstName());
//                u.setLastName(userDetails.getLastName());
//                return u;
//            }
//        }
//        return null;
    }
}
