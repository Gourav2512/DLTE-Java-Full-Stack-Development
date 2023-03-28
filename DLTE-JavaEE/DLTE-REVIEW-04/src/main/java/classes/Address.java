package classes;

import lombok.Data;

@Data
public class Address {
    private String door_no;
    private String street;
    private String city;
    private int pincode;
    private  String type;

    public Address(String door_no, String street, String city, int pincode, String type) {
        this.door_no = door_no;
        this.street = street;
        this.city = city;
        this.pincode = pincode;
        this.type = type;
    }

    public Address() {
    }
}
