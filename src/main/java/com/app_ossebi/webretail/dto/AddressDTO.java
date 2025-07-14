package com.app_ossebi.webretail.dto;

import lombok.Data;

@Data
public class AddressDTO {

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
