package org.skypro.skyshop.search;


public class BestResultNotFound extends Exception {
    public BestResultNotFound(String query) {
        super("Не найден лучший результат для поискового запроса: \"" + query + "\"");
    }
}
