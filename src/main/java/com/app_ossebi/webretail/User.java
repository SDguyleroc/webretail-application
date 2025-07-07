package com.app_ossebi.webretail;

import lombok.Data;

/**
 * Represents a user in the system.
 * This class is a data model containing user information.
 */
@Data
public class User {
    /**
     * The unique identifier for the user.
     */
    private Long id;
    
    /**
     * The first name of the user.
     */
    private String firstName;
    
    /**
     * The last name of the user.
     */
    private String lastName;
}
