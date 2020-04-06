package model;

public class DeliveryMan {
    private final int id;
    private final String phoneNumber;
    private final String appName;
    private final int customerID;

    public DeliveryMan(int id, String phoneNumber, String appName, int customerID) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.appName = appName;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAppName() {
        return appName;
    }

    public int getCustomerID() {
        return customerID;
    }
}
