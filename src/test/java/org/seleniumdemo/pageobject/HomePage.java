package org.seleniumdemo.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class HomePage {
    private final static By WOMEN_MENU = By.linkText("Women");

    private final WebDriver driver;

    public void loadHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public HomePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public void goToWomenSubcategory() {
        driver.findElement(WOMEN_MENU).click();
    }
}
