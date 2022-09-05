package jstl.product;

public class Product {
    private String code;
    private String name;
    private double price;
    private String des;

    public Product(String code, String name, double price, String des) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.des = des;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.des;
    }
}
