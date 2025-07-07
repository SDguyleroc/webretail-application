// /UserService.java
package com.app_ossebi.webretail;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private long id =0L;
    private final List<User> userList = new ArrayList<>();
    public List<User> fetchAllUsers() {
        return userList;
    }

    public void createUser(User user) {
        user.setId(id++);
        userList.add(user);
    }

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
