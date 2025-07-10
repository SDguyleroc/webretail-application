package com.app_ossebi.webretail.service;

import com.app_ossebi.webretail.model.User;
import com.app_ossebi.webretail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing user-related business logic.
 * Handles operations such as creating, retrieving, and managing users.
 */
@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    /**
     * Retrieves all users currently stored in the system.
     *
     * @return A list containing all users
     */
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Creates a new user and adds them to the system.
     * Automatically assigns a new ID to the user before saving.
     *
     * @param user The user object to be created
     */
    public void createUser(User user) {

        userRepository.save(user);
    }

    /**
     * Finds a user by their unique identifier.
     *
     * @param id The ID of the user to find
     * @return The found user, or a new empty User object if not found
     */
    public Optional<User> fetchUserById(long id) {

        return userRepository.findById(id);


//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst();

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

    public boolean updateUser(long id, User userDetails) {

        // JPA
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setLastName(userDetails.getFirstName());
                    existingUser.setLastName(userDetails.getLastName());
                    existingUser.setEmail(userDetails.getEmail());
                    existingUser.setPhoneNumber(userDetails.getPhoneNumber());
                    userRepository.save(existingUser);
                    return true;
                } ).orElse(false);


        // using stream with a List<User> userList = new ArrayList<>();
//        return userList.stream()
//                .filter(user -> user.getId().equals(id))
//                .findFirst()
//                .map(user -> {
//                    user.setFirstName(userDetails.getFirstName());
//                    user.setLastName(userDetails.getLastName());
//                    return user;
//                });


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
