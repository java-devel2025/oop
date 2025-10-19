package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new SimpleProduct("Хлеб", 40);
        Product milk = new DiscountedProduct("Молоко", 100, 20); // скидка 20%
        Product cheese = new DiscountedProduct("Сыр", 300, 10);  // скидка 10%
        Product membership = new FixPriceProduct("Подписка SkyPro+");

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(membership);

        System.out.println("\n--- Содержимое корзины ---");
        basket.printBasket();
    }
}
