package com.app_ossebi.webretail.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="address_table")
public class Address {

    /*
     * @Id for primary key
     * @GeneratedValue for auto increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
     * @Column for column name
     */
    private String street;

    /*
     * @Column for column name
     */
    private String city;

    /*
     * @Column for column name
     */
    private String state;

    /*
     * @Column for column name
     */
    private String zipCode;



}
