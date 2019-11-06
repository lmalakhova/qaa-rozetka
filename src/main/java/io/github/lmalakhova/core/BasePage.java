package io.github.lmalakhova.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import static io.github.lmalakhova.BaseConfig.BASE_CONFIG;
import static io.github.lmalakhova.core.WaitCondition.enable;
import static io.github.lmalakhova.core.WaitCondition.visible;
import static io.github.lmalakhova.core.WebDriverListener.getDriver;
import static io.github.lmalakhova.utils.ElementTypeUtils.elementOf;

/**
 * Class for Base Page with common methods.
 */

public abstract class BasePage implements Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(getDriver(), BASE_CONFIG.waitTimeOut());
        this.driver = getDriver();
    }

    public Page navigateTo() {
        driver.get(url());
        return this;
    }

    protected void type(final By locator, final CharSequence text, WaitCondition condition) {
        elementOf(waitFor(locator, condition)).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text) {
        type(locator, text, visible);
    }

    protected void click(final By locator) {
        waitFor(locator, enable);
    }

    protected void select(final By locator, final String text) {
        new Select(waitFor(locator, visible)).selectByVisibleText(text);
    }

    @SuppressWarnings("unchecked")
    private <T> T waitFor(final By locator, final WaitCondition condition) {
        return (T) wait.until(condition.getType().apply(locator));
    }

}
