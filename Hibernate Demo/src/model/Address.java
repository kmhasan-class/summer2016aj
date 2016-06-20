/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Embeddable;

/**
 *
 * @author kmhasan
 */
@Embeddable
public class Address {
    private String streetAddress;
    private String city;
    private String country;
    private String postalCode;

    public Address(String streetAddress, String city, String country, String postalCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Address() {
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return "Address{" + "streetAddress=" + streetAddress + ", city=" + city + ", country=" + country + ", postalCode=" + postalCode + '}';
    }
}
