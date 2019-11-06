package io.github.lmalakhova.pages;

import io.github.lmalakhova.core.BasePage;
import io.github.lmalakhova.core.WaitCondition;
import org.openqa.selenium.By;

import static io.github.lmalakhova.BaseConfig.BASE_CONFIG;


/**
 * Class for Main Page.
 */

public class MainPage extends BasePage {

    private By inputSearch = By.xpath("//input[@name=\"search\"]");

    public MainPage search(final String text) {
        type(inputSearch, text);
        return this;
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
