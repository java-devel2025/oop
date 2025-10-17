package org.skypro.skyshop.product;


public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Геттеры для получения данных
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return name + ": " + price;
    }
}
