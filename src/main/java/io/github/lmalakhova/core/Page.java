package io.github.lmalakhova.core;

/**
 * Interface for PageObjects with common methods.
 */
public interface Page {
    default Page navigateTo() {
        return navigateTo(url());
    }

    Page navigateTo(String url);

    default String url() {
        return "http://localhost";
    }

}
