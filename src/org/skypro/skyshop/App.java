package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        // Демонстрация валидации
        try {
            Product badProduct = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product badDiscount = new DiscountedProduct("Сыр", 200, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product badPrice = new SimpleProduct("Хлеб", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Создаем корректные продукты
        Product apple = new SimpleProduct("Яблоко", 50);
        Product milk = new DiscountedProduct("Молоко", 100, 20);
        Product cheese = new DiscountedProduct("Сыр", 300, 10);
        Product subscription = new FixPriceProduct("Подписка SkyPro+");

        // Создаем статьи
        Article article1 = new Article("Как выбрать сыр", "Сыр бывает разных сортов, важно учитывать вкус и жирность.");
        Article article2 = new Article("Польза молока", "Молоко полезно для костей и содержит кальций.");

        // Создаем поисковый движок
        SearchEngine engine = new SearchEngine(10);
        engine.add(apple);
        engine.add(milk);
        engine.add(cheese);
        engine.add(subscription);
        engine.add(article1);
        engine.add(article2);

        System.out.println("\n=== Поиск по слову 'молоко' ===");
        System.out.println(Arrays.toString(engine.search("молоко")));

        // Демонстрация нового метода поиска
        System.out.println("\n=== Поиск самого подходящего результата ===");
        try {
            Searchable best = engine.findBestMatch("сыр");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        // Попробуем поиск по несуществующему слову
        try {
            Searchable best = engine.findBestMatch("йогурт");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
