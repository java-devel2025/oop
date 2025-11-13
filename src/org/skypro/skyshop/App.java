package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Set;

public class App {
    public static void main(String[] args) {
        SearchEngine engine = new SearchEngine();

        // === Продукты ===
        Product apple = new SimpleProduct("Яблоко", 50);
        Product cheese = new DiscountedProduct("Сыр", 200, 15);
        Product milk = new FixPriceProduct("Молоко");

        // === Добавляем продукты ===
        engine.add(apple);
        engine.add(cheese);
        engine.add(milk);
        engine.add(apple); // ❌ дубликат — не добавится

        // === Статьи ===
        Article a1 = new Article("Польза молока", "Молоко полезно для костей");
        Article a2 = new Article("Как выбрать сыр", "Советы при покупке сыра");
        Article a3 = new Article("Молоко и кофе", "Сочетается ли молоко с кофе?");
        engine.add(a1);
        engine.add(a2);
        engine.add(a3);
        engine.add(a1); // ❌ дубликат — не добавится

        System.out.println("\n=== Поиск по слову 'молоко' ===");
        Set<Searchable> results = engine.search("молоко");
        for (Searchable s : results) {
            System.out.println(s.getStringRepresentation());
        }

        System.out.println("\n=== Лучший результат по 'сыр' ===");
        try {
            Searchable best = engine.findBestMatch("сыр");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
