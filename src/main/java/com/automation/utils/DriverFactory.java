package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {

        DriverFactory.driver = driver;
    }

    public static WebDriver getDriver() {
        ChromeOptions options = new ChromeOptions();

        // Modo incógnito
        options.addArguments("--incognito");
        return driver;
    }
}
