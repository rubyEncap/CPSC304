package model;
// Customer Service
public class CSO {
    private final int id;
    private final String name;
    private final String appName;
    private final int customerID;
    private final int salary;

    public CSO(int id, String name, String appName, int customerID, int salary) {
        this.id = id;
        this.name = name;
        this.appName = appName;
        this.customerID = customerID;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAppName() {
        return appName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getSalary() {
        return salary;
    }
}
