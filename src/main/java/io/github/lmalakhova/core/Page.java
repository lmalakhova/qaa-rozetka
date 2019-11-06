package io.github.lmalakhova.core;

/**
 * Interface for PageObjects with common methods.
 */
public interface Page {
    Page navigateTo();

    default String url() {
        return "http://localhost";
    }

}
