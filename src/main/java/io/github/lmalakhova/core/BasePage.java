package io.github.lmalakhova.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

import static io.github.lmalakhova.BaseConfig.BASE_CONFIG;
import static io.github.lmalakhova.core.WebDriverListener.getDriver;

public abstract class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(getDriver(), BASE_CONFIG.waitTimeOut());
        this.driver = getDriver();
    }

    protected void type(final By locator, final CharSequence text, Function<By, ExpectedCondition<WebElement>> condition) {
        waitFor(locator, condition).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text) {
        type(locator, text, ExpectedConditions::visibilityOfElementLocated);
    }

    protected void click(final By locator) {
        waitFor(locator, ExpectedConditions::elementToBeClickable);
    }

    private WebElement waitFor(final By locator, final Function<By, ExpectedCondition<WebElement>> condition) {
        return wait.until(condition.apply(locator));
    }

}
