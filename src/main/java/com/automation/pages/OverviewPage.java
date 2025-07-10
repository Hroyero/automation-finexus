package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage {

    private By resumenProductName = By.className("inventory_item_name");
    private By resumenProductPrice = By.className("inventory_item_price");
    private By resumenCustomerInfo = By.className("summary_info");
    private By resumenTotalPrice = By.className("summary_total_label");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getResumenProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resumenProductName)).getText();
    }

    public String getResumenProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resumenProductPrice)).getText();
    }

    public String getResumenCustomerInfo() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resumenCustomerInfo)).getText();
    }

    public String getResumenTotalPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resumenTotalPrice)).getText();
    }
}
