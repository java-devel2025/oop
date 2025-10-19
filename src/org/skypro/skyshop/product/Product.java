package org.skypro.skyshop.product;


public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    // Абстрактный метод получения цены
    public abstract int getPrice();

    // Метод определения "специального" товара (переопределяется в наследниках)
    public boolean isSpecial() {
        return false;
    }

    public String getName() {
        return name;
    }

    // Метод для строкового представления (разный в подклассах)
    @Override
    public abstract String toString();
}
