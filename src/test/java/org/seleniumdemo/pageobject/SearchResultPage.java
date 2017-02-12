package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class SearchResultPage {
    private final WebDriver driver;

    public SearchResultPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public boolean isResultItemDisplayed(String itemName) {
        return driver.findElement(By.cssSelector(String.format("img[alt='%s']", itemName))).isDisplayed();
    }
}
