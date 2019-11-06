package io.github.lmalakhova.core;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Function;

/**
 * Enum for WaitCondition types.
 */

@Getter
@RequiredArgsConstructor
public enum WaitCondition {

    visible(ExpectedConditions::visibilityOfElementLocated),
    present(ExpectedConditions::presenceOfElementLocated),
    enable(ExpectedConditions::elementToBeClickable),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy);

    private final Function<By, ExpectedCondition<?>> type;

}
