package com.app_ossebi.webretail.dto;

import com.app_ossebi.webretail.model.Address;
import com.app_ossebi.webretail.model.UserRole;
import lombok.Data;

@Data
public class UserRespond {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressDTO address;
    private UserRole role;
}
