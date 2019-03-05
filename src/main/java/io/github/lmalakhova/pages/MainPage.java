package io.github.lmalakhova.pages;

import io.github.lmalakhova.core.BasePage;
import org.openqa.selenium.By;

import static io.github.lmalakhova.core.WebDriverListener.getDriver;

/**
 * Class for Main Page.
 */

public class MainPage extends BasePage {
    private By inputSearch = By.xpath("//input[@name=\"search\"]");

    public MainPage search(final String text) {
        type(inputSearch, text);

        getDriver().findElement(inputSearch).sendKeys(text);
        return this;
    }

}
