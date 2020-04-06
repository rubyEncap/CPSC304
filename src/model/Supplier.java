package model;

public class Supplier {
    private final String name;
    private final String product;
    private final String storeName;
    private final int price;

    public Supplier(String name, String product, String storeName, int price) {
        this.name = name;
        this.product = product;
        this.storeName = storeName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getProduct() {
        return product;
    }

    public String getStoreName() {
        return storeName;
    }

    public int getPrice() {
        return price;
    }
}
