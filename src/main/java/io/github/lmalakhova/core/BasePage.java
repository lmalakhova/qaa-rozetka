package io.github.lmalakhova.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;


import static io.github.lmalakhova.BaseConfig.BASE_CONFIG;
import static io.github.lmalakhova.core.WaitCondition.enable;
import static io.github.lmalakhova.core.WaitCondition.visible;
import static io.github.lmalakhova.core.WebDriverListener.getDriver;

/**
 * Class for Base Page with common methods.
 */

public abstract class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(getDriver(), BASE_CONFIG.waitTimeOut());
        this.driver = getDriver();
    }

    protected void type(final By locator, final CharSequence text, WaitCondition condition) {
        waitFor(locator, condition).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text) {
        type(locator, text, visible);
    }

    protected void click(final By locator) {
        waitFor(locator, enable);
    }

    private WebElement waitFor(final By locator, final WaitCondition condition) {
        return wait.until(condition.getType().apply(locator));
    }

}
