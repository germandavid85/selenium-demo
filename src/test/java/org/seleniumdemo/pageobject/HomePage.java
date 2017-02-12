package org.seleniumdemo.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class HomePage {
    private final static By WOMEN_MENU = By.linkText("Women");
    private final static By SEARCH_FIELD = By.name("search_query");

    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public void goToWomenSubcategory() {
        driver.findElement(WOMEN_MENU).click();
    }

    public void loadHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public void search(String searchText) {
        Objects.requireNonNull(searchText);
        WebElement searchField = driver.findElement(SEARCH_FIELD);
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
    }
}
