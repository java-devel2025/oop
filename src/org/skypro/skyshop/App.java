package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        // создаем несколько продуктов
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 40);
        Product milk = new Product("Молоко", 70);
        Product cheese = new Product("Сыр", 120);
        Product meat = new Product("Мясо", 300);
        Product chocolate = new Product("Шоколад", 150);

        // создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавление продукта в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(meat);

        // Добавление продукта в заполненную корзину
        basket.addProduct(chocolate);

        // Печать содержимого корзины
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине Хлеб? " + basket.contains("Хлеб"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине Шоколад? " + basket.contains("Шоколад"));

        // Очистка корзины
        basket.clearBasket();

        // Печать пустой корзины
        basket.printBasket();

        // Стоимость пустой корзины
        System.out.println("Стоимость пустой корзины: " + basket.getTotalPrice());

        // Поиск товара в пустой корзине
        System.out.println("Есть ли в корзине Яблоко? " + basket.contains("Яблоко"));
    }
}
