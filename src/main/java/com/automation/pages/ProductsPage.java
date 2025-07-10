package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private By firstProductLink = By.className("inventory_item_name");  // link del primer producto visible
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // Selecciona el primer producto de la lista de productos
    public void selectFirstProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductLink)).click();
    }

    // Click en Add to Cart (si se llama aquí en la página de productos)
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Ir al carrito desde el icono de carrito
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }
}
