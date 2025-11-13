package org.skypro.skyshop.search;
import java.util.*;


public class SearchEngine {
    // 🔹 теперь используем Set — убираем дубликаты
    private final Set<Searchable> items = new HashSet<>();

    public void add(Searchable searchable) {
        items.add(searchable); // HashSet автоматически не добавит дубликат
    }

    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

        if (query == null || query.isBlank()) {
            return results;
        }

        String lower = query.toLowerCase();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(lower)) {
                results.add(item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable best = null;
        int maxOccurrences = 0;

        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), query.toLowerCase());
            if (count > maxOccurrences) {
                maxOccurrences = count;
                best = item;
            }
        }

        if (best == null) {
            throw new BestResultNotFound(query);
        }
        return best;
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
