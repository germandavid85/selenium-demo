package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CategoryPage {
    private static final By TOP_CATEGORY = By.linkText("Tops");

    private final WebDriver driver;

    public CategoryPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public void goToTopSubCategory() {
        driver.findElement(TOP_CATEGORY).click();
    }
}
