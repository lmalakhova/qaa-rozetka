package io.github.lmalakhova.core;

import lombok.experimental.UtilityClass;

import static org.joor.Reflect.on;

/**
 * PageFactory for PageObjects initialization.
 */
@UtilityClass
public class
PageFactory {
    @SuppressWarnings("unchecked")
    public static <T extends Page> T open(final Class<T> pageClass) {
        T page = on(pageClass).create().get();
        return (T) page.navigateTo();
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }
}
