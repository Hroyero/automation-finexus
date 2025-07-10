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

    @Given("el usuario inicia sesion en Saucedemo con credenciales validas")
    public void login() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }
    @When("navega al catalogo de productos y ve el titulo {string}")
    public void navegarCatalogo(String expectedTitle) {
        String actualTitle = loginPage.getPageTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @When("selecciona un producto disponible")
    public void seleccionarProducto() {
        productsPage.selectFirstProduct();
    }

    @Then("el sistema muestra el detalle del producto correctamente")
    public void validarDetalleProducto() {
        assertTrue(driver.getCurrentUrl().contains("inventory-item"));
    }

    @Given("el usuario esta en la pagina de detalle de un producto valido")
    public void usuarioEnDetalleProducto() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.selectFirstProduct();
    }

    @When("hace clic en el boton Add to cart")
    public void clickAddToCart() {
        productDetailPage.addToCart();
    }

    @And("navega al carrito de compras")
    public void navegarCarrito() {
        productDetailPage.goToCart();
    }

    @Then("el carrito muestra el nombre del producto y precio correcto")
    public void validarCarrito() {
        String nameDetail = productDetailPage.getProductName();
        String nameCart = cartPage.getItemName();
        String priceDetail = productDetailPage.getProductPrice();
        String priceCart = cartPage.getItemPrice();
       // String quantityCart = cartPage.getItemQuantity();
        assertEquals("El nombre del producto no coincide", nameDetail, nameCart);
        assertEquals("El precio del producto no coincide.", priceDetail, priceCart);
        //assertEquals("La cantidad deberia ser 1.", "1", quantityCart);
    }

}