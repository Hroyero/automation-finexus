package com.automation.stepdefinitions;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("el usuario esta en la pagina de login")
    public void openBrowser() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("el usuario ingresa credenciales username {string} y password {string}")
    public void they_enter_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("el usuario deberia ver el texto {string}")
    public void theyShouldSeeTheText(String expectedText) {
        assertTrue(loginPage.getProductTitle().contains(expectedText));
        System.out.println("Texto experado: " + expectedText );
    }
}
