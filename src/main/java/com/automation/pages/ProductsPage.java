package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private By productLink = By.xpath("//div[@class='inventory_item']//a");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void selectFirstProduct() {
        driver.findElement(productLink).click();
    }

    public void addProductToCart(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']")
        )).click();
    }

    public String getCartBadgeCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("shopping_cart_badge")
        )).getText();
    }
}
