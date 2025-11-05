package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        // === Создание продуктов ===
        Product apple = new SimpleProduct("Яблоко", 50);
        Product milk = new DiscountedProduct("Молоко", 100, 20);
        Product cheese = new DiscountedProduct("Сыр", 300, 10);
        Product sub = new FixPriceProduct("Подписка SkyPro+");

        // === Корзина ===
        ProductBasket basket = new ProductBasket();
        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(sub);
        basket.addProduct(new SimpleProduct("Яблоко", 60)); // второе яблоко

        System.out.println("=== Содержимое корзины ===");
        basket.printBasket();

        // === Удаление продукта ===
        System.out.println("\nУдаляем продукт 'Яблоко'...");
        List<Product> removed = basket.removeProductsByName("Яблоко");
        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            System.out.println("Удалено:");
            for (Product p : removed) {
                System.out.println(p);
            }
        }

        System.out.println("\nКорзина после удаления:");
        basket.printBasket();

        // === Поисковой движок ===
        SearchEngine engine = new SearchEngine();
        engine.add(apple);
        engine.add(milk);
        engine.add(cheese);
        engine.add(sub);
        engine.add(new Article("Как выбрать сыр", "Сыр бывает разных сортов"));
        engine.add(new Article("Польза молока", "Молоко полезно для костей"));

        System.out.println("\n=== Поиск по строке 'сыр' ===");
        Map<String, Searchable> results = engine.search("сыр");
        for (Map.Entry<String, Searchable> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue().getStringRepresentation());
        }

        System.out.println("\n=== Лучший результат по 'молоко' ===");
        try {
            Searchable best = engine.findBestMatch("молоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
