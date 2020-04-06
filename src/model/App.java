package model;

public class App {
    private final String name;
    private final String manager;

    public App(String name, String manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }
}
