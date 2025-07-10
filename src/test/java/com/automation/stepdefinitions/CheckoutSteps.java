package com.automation.stepdefinitions;

import com.automation.pages.*;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    OverviewPage overviewPage = new OverviewPage(driver);

    @Given("el usuario tiene un producto en el carrito de compras")
    public void theUserHasAProductInTheCart() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectFirstProduct(); // Debes tener este método en ProductsPage
        productsPage.addToCart();
        productsPage.goToCart();
    }

    @When("navega al checkout")
    public void navigateToCheckout() {
        cartPage.clickCheckout();
    }

    @And("completa el formulario de checkout con {string}, {string}, {string}")
    public void completeCheckoutForm(String fName, String lName, String zip) {
        checkoutPage.fillCheckoutForm(fName, lName, zip);
    }

    @And("hace clic en continuar")
    public void clickContinue() {
        checkoutPage.clickContinue();
    }

    @Then("El usuario deberia ver un mensaje de confirmacion {string}")
    public void userSeesConfirmationMessage(String expectedMessage) {
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        String actualMessage = checkoutPage.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("El mensaje de error de pago deberia ser {string}")
    public void paymentErrorMessage(String expectedError) {
        String actualError = checkoutPage.getErrorMessage();
        assertEquals(expectedError, actualError);
    }

    @Given("el usuario completa el formulario de checkout con datos validos")
    public void userCompletesValidCheckoutForm() {
        theUserHasAProductInTheCart();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.clickContinue();
    }

    @When("revisa la pagina de resumen de compra")
    public void reviewSummaryPage() {
        String summary = checkoutPage.getSummaryTitle();
        assertTrue(summary.contains("Checkout: Overview"));
    }

    @Then("el resumen muestra productos seleccionados, precio total y datos del cliente correctamente")
    public void validateFinalSummary() {
       //String nameDetail = productDetailPage.getProductName();
        String nameResumen = overviewPage.getResumenProductName();
        //String priceDetail = productDetailPage.getProductPrice();
        String priceResumen = overviewPage.getResumenProductPrice();
        String totalResumen = overviewPage.getResumenTotalPrice();
        String customerInfo = overviewPage.getResumenCustomerInfo();

        assertEquals( "Sauce Labs Backpack", nameResumen);
        assertEquals( "$29.99", priceResumen);
        assertEquals( "Total: $32.39", totalResumen);

    }
}
