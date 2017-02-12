package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class ProductDetailPage {
    private static final By SUBMIT_BUTTON = By.name("Submit");
    private static final By CHECKOUT_BUTTON = By.cssSelector("a[title='Proceed to checkout']");

    private final WebDriver driver;

    public ProductDetailPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public void addProductToCart() {
        driver.findElement(SUBMIT_BUTTON).click();
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
