package com.app_ossebi.webretail.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

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

    /**
     * The email address of the user.
     */
    private String email;

    /**
     * The phone number of the user.
     */
    private String phoneNumber;

    /**
     * The role of the user.
     * assigns a default value of UserRole.CUSTOMER.
     */
    private UserRole role = UserRole.CUSTOMER; // Default role

    /**
     * The address of the user.
     *  user can have only one address
     *  orphanRemoval = true ensures that the address is deleted when the user is deleted
     *  cascade = CascadeType.ALL ensures that the address is deleted when the user is deleted
     *  @JoinColumn(name = "address_id" , referencedColumnName = "id") specifies the name of the foreign key column in the user table
     */
    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true
             )
    @JoinColumn(name = "address_id" , referencedColumnName = "id")
    private Address address;

    /**
     * The date and time when the user was created.
     * @CreationTimestamp automatically assigns the current date and time when a new user is created in the database
     */
    @CreationTimestamp
    private LocalDateTime createdAt;

    /**
     * The date and time when the user was last updated.
     * @UpdateTimestamp automatically assigns the current date and time when a user is updated in the database
     */
    @UpdateTimestamp
    private LocalDateTime updatedAt;



}
