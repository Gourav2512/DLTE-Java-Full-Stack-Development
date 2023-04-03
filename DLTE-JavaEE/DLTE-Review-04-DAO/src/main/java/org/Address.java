package org;

import lombok.Data;

@Data
public class Address {

    private String door_no;
    private String street;
    private String city;
    private int pincode;

    public Address(String door_no, String street, String city, int pincode) {
        this.door_no = door_no;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
    }

    public Address() {
    }
}
