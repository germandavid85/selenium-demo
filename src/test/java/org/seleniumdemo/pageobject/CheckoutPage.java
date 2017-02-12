package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class CheckoutPage {
    private static final By TOTAL_PRICE_LABEL = By.id("total_price_container");
    private static final By SHOPPING_CART_OPTION = By.cssSelector("a[title='View my shopping cart']");
    private static final By REMOVE_ELEMENT_ICON = By.cssSelector("a.ajax_cart_block_remove_link");
    private static final By SHOPPING_CART_EMPTY_LABEL = By.cssSelector(".ajax_cart_no_product");

    private final WebDriver driver;

    public CheckoutPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
    }

    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE_LABEL).getText();
    }

    public void cleanShoppingCart() throws Exception {
        WebElement shoppingCartOption = driver.findElement(SHOPPING_CART_OPTION);
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartOption);
        actions.perform();

        driver.findElement(REMOVE_ELEMENT_ICON).click();
    }

    public boolean isShoppingCartEmpty() {
        new WebDriverWait(driver, 1)
            .until((WebDriver driver1) -> driver1.findElement(SHOPPING_CART_EMPTY_LABEL).isDisplayed());
        return driver.findElement(SHOPPING_CART_EMPTY_LABEL).isDisplayed();
    }
}
