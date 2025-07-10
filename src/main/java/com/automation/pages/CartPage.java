package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private By cartItemName = By.xpath("//div[contains(@class,'inventory_details_name')]");
    private By cartItemPrice = By.xpath("//div[contains(@class,'inventory_details_price')]");
    private By cartItemQuantity = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='cart_contents_container']/div/div[@class='cart_list']/div[3]/div[1]");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemName)).getText();
    }

    public String getItemPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemPrice)).getText();
    }

    public String getItemQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartItemQuantity)).getText();
    }


}
