package org.skypro.skyshop.search;
import java.util.*;


public class SearchEngine {
    private final List<Searchable> items = new ArrayList<>();

    //Добавить объект для поиска
    public void add(Searchable searchable) {
        items.add(searchable);
    }

    //Найти все результаты, содержащие поисковую строку
    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        if (query == null || query.isBlank()) return results;

        String lower = query.toLowerCase();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(lower)) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    //Найти лучший результат (из предыдущей домашки)
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
