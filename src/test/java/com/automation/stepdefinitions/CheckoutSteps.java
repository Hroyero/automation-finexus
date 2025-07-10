package com.automation.stepdefinitions;

import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
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

    @Given("el usuario tiene un producto en el carrito de compras")
    public void elUsuarioTieneUnProductoEnElCarrito() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectFirstProduct(); // Debes tener este método en ProductsPage
        productsPage.addToCart();
        productsPage.goToCart();
    }

    @When("navega al checkout")
    public void navegaAlCheckout() {
        cartPage.clickCheckout();
    }

    @And("completa el formulario de checkout con {string}, {string}, {string}")
    public void completaFormularioCheckout(String fName, String lName, String zip) {
        checkoutPage.fillCheckoutForm(fName, lName, zip);
    }

    @And("hace clic en continuar")
    public void haceClicEnContinuar() {
        checkoutPage.clickContinue();
    }

    @Then("El usuario debería ver un mensaje de confirmacion {string}")
    public void elUsuarioVeMensajeConfirmacion(String expectedMessage) {
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
        String actualMessage = checkoutPage.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("El mensaje de error de pago deberia ser {string}")
    public void mensajeErrorPago(String expectedError) {
        String actualError = checkoutPage.getErrorMessage();
        assertEquals(expectedError, actualError);
    }

    @Given("el usuario completa el formulario de checkout con datos validos")
    public void usuarioCompletaCheckoutValido() {
        elUsuarioTieneUnProductoEnElCarrito();
        cartPage.clickCheckout();
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.clickContinue();
    }

    @When("revisa la pagina de resumen de compra")
    public void revisaResumen() {
        String summary = checkoutPage.getSummaryTitle();
        assertTrue(summary.contains("Checkout: Overview"));
    }

    @Then("el resumen muestra productos seleccionados, precio total y datos del cliente correctamente")
    public void validarResumenFinal() {
        // Aquí podrías agregar asserts más específicos:
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
    }
}
