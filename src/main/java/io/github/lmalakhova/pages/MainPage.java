package io.github.lmalakhova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static io.github.lmalakhova.core.WebDriverListener.getDriver;

/**
 * Class for Main Page.
 */

public class MainPage {
    private By inputSearch = By.xpath("//input[@name=\"search\"]");

    public MainPage search(final String text) {
        getDriver().findElement(inputSearch).sendKeys(text);
        return this;
    }

}
