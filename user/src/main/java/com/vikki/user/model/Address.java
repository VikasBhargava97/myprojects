package com.vikki.user.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Base64;
import java.util.UUID;


@Data
public class Address implements Serializable {
    private String addressId;
    private String addressType;
    private String flatNo;
    private String building;
    private String street;
    private String area;
    private String pincode;
    private String state;
    private String city;
    private String country;

    public Address()
    {
        this.addressId = Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }
}
