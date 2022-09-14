package us.charterbank.online;

public class Address {
    protected String streetName;
    protected int streetNumber;
    protected String cityName;
    protected int cityZipCode;
    protected String state;
    protected String country;

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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityZipCode() {
        return cityZipCode;
    }

    public void setCityZipCode(int cityZipCode) {
        this.cityZipCode = cityZipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + cityName + ", " + state + " " + cityZipCode;
    }
}
