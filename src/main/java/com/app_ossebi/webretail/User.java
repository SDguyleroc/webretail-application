package com.app_ossebi.webretail;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a user in the system.
 * This class is a data model containing user information.
 */
@Data // Generates getter and setter methods
@Entity(name = "user_table") // Indicates that this class is a JPA entity and should be mapped to a database table
@NoArgsConstructor // Generates a no-argument constructor
//@AllArgsConstructor // Generates a constructor with all arguments
public class User {
    /**
     * The unique identifier for the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
