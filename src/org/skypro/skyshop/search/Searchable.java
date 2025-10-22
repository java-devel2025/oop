package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getSearchType();

    String getName();

    default String getStringRepresentation() {
        return getName() + " — " + getSearchType();
    }
}
