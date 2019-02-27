package io.github.lmalakhova.core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static java.util.Optional.ofNullable;

/**
 * Listener Class for WebDriver Initialization and Quits.
 */
public class WebDriverListener implements IInvokedMethodListener {
    private static final ThreadLocal<WebDriver> DRIVER_CONTAINER = new ThreadLocal<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            DRIVER_CONTAINER.set(new ChromeDriver());

        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ofNullable(getDriver()).ifPresent(WebDriver::quit);
        }

    }

    public static WebDriver getDriver() {
        return DRIVER_CONTAINER.get();
    }
}
