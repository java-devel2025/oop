package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        // Создаем товары
        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new SimpleProduct("Хлеб", 40);
        Product milk = new DiscountedProduct("Молоко", 100, 20);
        Product cheese = new DiscountedProduct("Сыр", 300, 10);
        Product subscription = new FixPriceProduct("Подписка SkyPro+");

        // Создаем статьи
        Article article1 = new Article("Как выбрать сыр", "Советы по выбору качественного сыра в магазине.");
        Article article2 = new Article("Польза молока", "Почему молоко — это источник кальция и витаминов.");
        Article article3 = new Article("Лучшие яблоки", "Сравнение сортов яблок по вкусу и сладости.");

        // Создаем поисковый движок и добавляем всё в него
        SearchEngine engine = new SearchEngine(10);
        engine.add(apple);
        engine.add(bread);
        engine.add(milk);
        engine.add(cheese);
        engine.add(subscription);
        engine.add(article1);
        engine.add(article2);
        engine.add(article3);

        // Демонстрация поиска
        System.out.println("\n=== Поиск по слову 'молоко' ===");
        System.out.println(Arrays.toString(engine.search("молоко")));

        System.out.println("\n=== Поиск по слову 'сыр' ===");
        System.out.println(Arrays.toString(engine.search("сыр")));

        System.out.println("\n=== Поиск по слову 'яблок' ===");
        System.out.println(Arrays.toString(engine.search("яблок")));

        System.out.println("\n=== Поиск по слову 'подписка' ===");
        System.out.println(Arrays.toString(engine.search("подписка")));
    }
}
