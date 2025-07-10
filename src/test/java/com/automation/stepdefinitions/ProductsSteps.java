package com.automation.stepdefinitions;

import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductDetailPage;
import com.automation.pages.ProductsPage;
import com.automation.utils.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    ProductDetailPage productDetailPage = new ProductDetailPage(driver);
    CartPage cartPage = new CartPage(driver);


    String nameDetail;
    String priceDetail;

    @Given("el usuario inicia sesion en Saucedemo con credenciales validas")
    public void login() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("navega al catalogo de productos y ve el titulo {string}")
    public void goToCatalog(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("selecciona un producto disponible")
    public void productSelect() {
        productsPage.selectFirstProduct();
    }

    @Then("el sistema muestra el detalle del producto correctamente")
    public void detailProduct() {
        assertTrue(driver.getCurrentUrl().contains("inventory-item"));
    }

    @Given("el usuario esta en la pagina de detalle de un producto valido")
    public void detailUserProduct() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectFirstProduct();
    }

    @When("hace clic en el boton Add to cart")
    public void clickAddToCart() {

        nameDetail = productDetailPage.getProductName();
        priceDetail = productDetailPage.getProductPrice();

        productDetailPage.addToCart();
    }

    @And("navega al carrito de compras")
    public void goToCart() {
        productDetailPage.goToCart();
    }

    @Then("el carrito muestra el nombre del producto y precio correcto")
    public void validateCart() {
        assertEquals( nameDetail, "Sauce Labs Backpack");
        assertEquals( priceDetail, "$29.99");
    }
}
