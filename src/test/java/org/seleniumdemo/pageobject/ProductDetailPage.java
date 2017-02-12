package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.function.Predicate;

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

        new WebDriverWait(driver, 1)
            .until((WebDriver driver1) -> driver1.findElement(CHECKOUT_BUTTON).isDisplayed());

        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
