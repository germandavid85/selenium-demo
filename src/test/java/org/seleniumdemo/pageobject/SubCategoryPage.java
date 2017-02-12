package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class SubCategoryPage {
    private final WebDriver driver;

    public SubCategoryPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public void goToProductDetails(String productName) {
        Objects.requireNonNull(productName);
        WebElement productImage = driver.findElement(By.cssSelector(String.format("img[title='%s']", productName)));

        Actions actions = new Actions(driver);
        actions.moveToElement(productImage);
        actions.perform();
        productImage.click();
    }
}
