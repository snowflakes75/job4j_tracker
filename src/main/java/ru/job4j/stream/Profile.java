package ru.job4j.stream;

public class Profile {
    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    private Address address;
}
