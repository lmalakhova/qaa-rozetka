package io.github.lmalakhova;

import io.github.lmalakhova.pages.MainPage;
import io.qameta.allure.*;
import io.vavr.control.Try;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static io.github.lmalakhova.core.PageFactory.open;

/**
 * Tests for Rozetka.com page.
 */

public class RozetkaTests {

    @Test(description = "Should search for keyword")
    @Feature("Search")
    @Story("9")
    @Issue("9")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForKeyword() {
        open(MainPage.class)
                .search("GeForce" + Keys.ENTER);
        Try.run(() -> Thread.sleep(5000)).onFailure(System.out::println);
    }
}
