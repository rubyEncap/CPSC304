package model;

public class Customer {
    private final int id;
    private final String name;
    private final String phoneNumber;
    private final String address;
    private final String email;
    private final String gender;
    private final int fee;

    public Customer(int id, String name, String phoneNumber, String gender, String address, String email, int fee) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getFee() {
        return fee;
    }
}
