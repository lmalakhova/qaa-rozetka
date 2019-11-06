package io.github.lmalakhova.utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

/**
 * Utility class for types casting.
 */
@UtilityClass
public class ElementTypeUtils {
    public static <T> WebElement elementOf(final T element) {
        return (WebElement) element;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<WebElement> listOf(final T element) {
        return (List<WebElement>) element;

    }

    public static <T> Stream<WebElement> streamOf(final T element) {
        return listOf(element).stream();
    }
}
