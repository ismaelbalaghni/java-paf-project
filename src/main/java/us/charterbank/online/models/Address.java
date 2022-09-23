package us.charterbank.online.models;

import java.io.Serializable;

public class Address implements Serializable {
    protected String streetName;
    protected int streetNumber;
    protected String cityName;
    protected int cityZipCode;
    protected String state;
    protected String country;

    public Address() {
    }

    public Address(String streetName, int streetNumber, String cityName, int cityZipCode, String state) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.cityName = cityName;
        this.cityZipCode = cityZipCode;
        this.state = state;
    }

    public Address(String streetName, int streetNumber, String cityName, int cityZipCode, String state, String country) {
        this(streetName, streetNumber, cityName, cityZipCode, state);
        this.country = country;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + cityName + ", " + state + " " + cityZipCode;
    }
}
