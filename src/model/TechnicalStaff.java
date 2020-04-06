package model;

public class TechnicalStaff {
    private final int id;
    private final String name;
    private final String appName;
    private final int salary;

    public TechnicalStaff(int id, String name, String appName, int salary) {
        this.id = id;
        this.name = name;
        this.appName = appName;
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

    public int getSalary() {
        return salary;
    }
}
