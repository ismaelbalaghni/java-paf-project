package us.charterbank.online;

public class Person {
    protected String name;
    protected Address address;
    protected String phoneNumber = "unknown";
    private String birthDate = "unknown";
    private String gender = "unknown";

    public Person(String name, String address) {
        this.name = name;
        String[] splitAddress = address.split(", ");
        this.address = new Address(splitAddress[0], Integer.parseInt(splitAddress[1]), splitAddress[2], Integer.parseInt(splitAddress[3]), splitAddress[4]);
    }

    public Person(String name, String address, String birthDate, String gender) {
        this(name, address);
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Person(String name, String address, String birthDate, String gender, String phoneNumber) {
        this(name, address, birthDate, gender);
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String[] splitAddress = address.replace(" ", "").split(",");
        this.address = new Address(splitAddress[0], Integer.parseInt(splitAddress[1]), splitAddress[2], Integer.parseInt(splitAddress[3]), splitAddress[4]);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
