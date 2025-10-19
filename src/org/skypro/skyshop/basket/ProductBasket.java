package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];

    // Добавление продукта
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                System.out.println("Продукт \"" + product.getName() + "\" добавлен в корзину.");
                return;
            }
        }
        System.out.println("Невозможно добавить продукт: корзина заполнена.");
    }

    // Общая стоимость корзины
    public int getTotalPrice() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    // Печать содержимого корзины
    public void printBasket() {
        boolean empty = true;
        int specialCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                empty = false;
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        if (empty) {
            System.out.println("В корзине пусто.");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    // Проверка по имени
    public boolean contains(String name) {
        for (Product product : products) {
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Очистка корзины
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        System.out.println("Корзина очищена.");
    }
}
