package org.skypro.skyshop.product;
import org.skypro.skyshop.search.Searchable;
import java.util.Objects;


public abstract class Product implements Searchable {
    private final String name;

    protected Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или null");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    // ✅ сравнение продуктов только по имени
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equalsIgnoreCase(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() {
        return name + " — " + getSearchType();
    }
}
