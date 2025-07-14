package com.app_ossebi.webretail.service;

import com.app_ossebi.webretail.dto.AddressDTO;
import com.app_ossebi.webretail.dto.UserRequest;
import com.app_ossebi.webretail.dto.UserRespond;
import com.app_ossebi.webretail.model.Address;
import com.app_ossebi.webretail.model.User;
import com.app_ossebi.webretail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<UserRespond> fetchAllUsers() {
        return userRepository.findAll()
                .stream().map(this::mapToUserRespond).collect(Collectors.toList());
    }

    /**
     * Creates a new user and adds them to the system.
     * Automatically assigns a new ID to the user before saving.
     *
     * @param userRequest The user object to be created
     */
    public void createUser(UserRequest userRequest) {

        User user = new User();
        UpdateUserFromUserRequest(userRequest, user);
        userRepository.save(user);
    }



    /**
     * Finds a user by their unique identifier.
     *
     * @param id The ID of the user to find
     * @return The found user, or a new empty User object if not found
     */
    public Optional<UserRespond> fetchUserById(long id) {

        return userRepository.findById(id).map(this::mapToUserRespond);


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

    public boolean updateUser(long id, UserRequest updatedUserRequest) {

        // JPA
        // using a lambda expression to update the user details in the database using the provided ID and new user details
        // if the user is found, update the user details and return true otherwise return false
        return userRepository.findById(id)
                .map(existingUser -> {
                    UpdateUserFromUserRequest(updatedUserRequest, existingUser);
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

    private void UpdateUserFromUserRequest(UserRequest userRequest, User user) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhoneNumber(userRequest.getPhoneNumber());

        if(userRequest.getAddress() != null){
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setCity(userRequest.getAddress().getCity());
            address.setState(userRequest.getAddress().getState());
            address.setZipCode(userRequest.getAddress().getZipCode());
            user.setAddress(address);

        }
    }

    private UserRespond mapToUserRespond(User user) {
        UserRespond userRespond = new UserRespond();
        userRespond.setId(String.valueOf(user.getId()));
        userRespond.setFirstName(user.getFirstName());
        userRespond.setLastName(user.getLastName());
        userRespond.setEmail(user.getEmail());
        userRespond.setPhoneNumber(user.getPhoneNumber());
        userRespond.setRole(user.getRole());

        if(user.getAddress() != null){
            AddressDTO address = new AddressDTO();
            address.setStreet(user.getAddress().getStreet());
            address.setCity(user.getAddress().getCity());
            address.setState(user.getAddress().getState());
            address.setZipCode(user.getAddress().getZipCode());
            userRespond.setAddress(address);
        }

        return userRespond;


    }
}
