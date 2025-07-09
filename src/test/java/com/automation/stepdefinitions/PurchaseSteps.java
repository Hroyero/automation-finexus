package com.automation.stepdefinitions;

import com.automation.pages.LoginPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class PurchaseSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("el usuario inicia sesion en Saucedemo con credenciales validas")
    public void login() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }
}