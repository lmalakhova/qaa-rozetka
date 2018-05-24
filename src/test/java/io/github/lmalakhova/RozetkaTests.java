package io.github.lmalakhova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RozetkaTests {

    @Test
    public void shouldSearchForKeyword() throws InterruptedException {
        WebDriverManager.getInstance(ChromeDriver.class).setup();
        final WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rozetka.com.ua");
        final WebElement element = driver.findElement(By.xpath("//input[@name=\"text\"]"));
        element.sendKeys("GeForce");
        Thread.sleep(5000);
        driver.quit();
    }
}
