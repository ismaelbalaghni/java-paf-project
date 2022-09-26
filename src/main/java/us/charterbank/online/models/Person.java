package us.charterbank.online.models;

import java.io.Serializable;

public class Person implements Serializable {
    protected String name;
    protected Address address;

    public Person() {
    }

    public Person(String name, String address) {
        this.name = name;
        String[] splitAddress = address.split(", ");
        this.address = new Address(splitAddress[0], Integer.parseInt(splitAddress[1]), splitAddress[2], splitAddress[3], splitAddress[4]);
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

}
