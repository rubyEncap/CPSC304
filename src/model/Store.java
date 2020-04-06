package model;

public class Store {
    private final String name;
    private final String address;
    private final String goodType;
    private final String appName;

    public Store(String name, String address, String goodType, String appName) {
        this.name = name;
        this.address = address;
        this.goodType = goodType;
        this.appName = appName;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGoodType() {
        return goodType;
    }

    public String getAppName() {
        return appName;
    }
}
