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
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product p : productList) {
                total += p.getPrice();
            }
        }
        return total;
    }

    // Печать содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int total = 0;
        int specialCount = 0;

        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product p : entry.getValue()) {
                System.out.println(p.toString());
                total += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
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
}
