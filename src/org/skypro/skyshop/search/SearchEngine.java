package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.items = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (currentIndex >= items.length) {
            System.out.println("Невозможно добавить элемент — хранилище переполнено.");
            return;
        }
        items[currentIndex++] = searchable;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;
        query = query.toLowerCase();

        for (Searchable item : items) {
            if (item == null) continue;

            if (item.getSearchTerm().toLowerCase().contains(query)) {
                results[found++] = item;
                if (found == results.length) {
                    break;
                }
            }
        }
        return results;
    }
}
