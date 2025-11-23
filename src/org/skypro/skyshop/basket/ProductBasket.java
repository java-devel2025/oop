package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();

    // Добавление продукта
    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Общая стоимость корзины
    public int getTotalPrice() {
        return products.values().stream()               // Stream<List<Product>>
                .flatMap(Collection::stream)            // Stream<Product>
                .mapToInt(Product::getPrice)
                .sum();
    }

    // Печать содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        // Печать всех продуктов
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(p -> System.out.println(p.toString()));

        // Подсчёт общей стоимости
        int total = products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();

        // Подсчёт специальных продуктов
        long specialCount = getSpecialCount();

        System.out.println("Общая стоимость: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Проверка по имени
    public boolean hasProduct(String name) {
        return products.containsKey(name);
    }

    // Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    // Удалить продукт(ы) по имени. Возвращает список удалённых товаров.
    public List<Product> removeProductsByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }

    // подсчёт спецтоваров
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}
