package model;

public class Account {
    private final int id;
    private final String password;
    private final String appName;

    public Account(int id, String password, String appName) {
        this.id = id;
        this.password = password;
        this.appName = appName;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getAppName() {
        return appName;
    }
}
