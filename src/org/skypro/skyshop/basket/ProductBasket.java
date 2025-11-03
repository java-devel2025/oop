package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    // Добавление продукта
    public void addProduct(Product product) {
        products.add(product);
    }

    // Общая стоимость корзины
    public int getTotalPrice() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice();
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

        for (Product p : products) {
            System.out.println(p.toString());
            total += p.getPrice();
            if (p.isSpecial()) {
                specialCount++;
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Проверка по имени
    public boolean hasProduct(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Очистка корзины
    public void clearBasket() {
        products.clear();
    }

    // Удалить продукт(ы) по имени. Возвращает список удалённых товаров.
    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equalsIgnoreCase(name)) {
                removed.add(p);
                iterator.remove();
            }
        }
        return removed;
    }
}
