package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {

    private By summaryInfo = By.className("summary_info");

    public OverviewPage(WebDriver driver) {
        super(driver);
    }


    public boolean isSummaryDisplayed() {
        return driver.findElement(summaryInfo).isDisplayed();
    }
}
