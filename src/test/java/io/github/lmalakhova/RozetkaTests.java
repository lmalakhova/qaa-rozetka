package io.github.lmalakhova;

import io.github.lmalakhova.pages.MainPage;
import io.vavr.control.Try;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static io.github.lmalakhova.BaseConfig.BASE_CONFIG;
import static io.github.lmalakhova.core.WebDriverListener.getDriver;

/**
 * Tests for Rozetka.com page.
 */

public class RozetkaTests {

    @Test
    public void shouldSearchForKeyword() {
        getDriver().navigate().to(BASE_CONFIG.url());
        new MainPage().search("GeForce");
        Try.run(() -> Thread.sleep(5000)).onFailure(System.out::println);
    }
}
