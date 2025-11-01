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

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        if (query == null || query.isBlank()) {
            throw new BestResultNotFound("Пустой запрос");
        }

        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            if (item == null) continue;
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), query.toLowerCase());
            if (count > maxOccurrences) {
                maxOccurrences = count;
                bestMatch = item;
            }
        }

        if (bestMatch == null || maxOccurrences == 0) {
            throw new BestResultNotFound(query);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = text.indexOf(sub);
        while (index != -1) {
            count++;
            index = text.indexOf(sub, index + sub.length());
        }
        return count;
    }
}
