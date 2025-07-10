package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailPage extends BasePage {

    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartIcon = By.className("shopping_cart_link");
    private By productName = By.xpath("//div[contains(@class,'inventory_details_name')]");
    private By productPrice = By.xpath("//div[contains(@class,'inventory_details_price')]");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getProductName() {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText();
    }
}
