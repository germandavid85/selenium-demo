package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class CheckoutPage {
    @FindBy(id = "total_price_container")
    private WebElement totalPriceLabel;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement shoppingCartOption;

    @FindBy(css = "a.ajax_cart_block_remove_link")
    private WebElement removeElementIcon;

    @FindBy(css = ".ajax_cart_no_product")
    private WebElement shoppingCartEmptyLabel;
    private static final By SHOPPING_CART_EMPTY_LABEL = By.cssSelector(".ajax_cart_no_product");

    private final WebDriver driver;


    public CheckoutPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getTotalPrice() {
        return totalPriceLabel.getText();
    }

    public void cleanShoppingCart() throws Exception {
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCartOption);
        actions.perform();

        removeElementIcon.click();
    }

    public boolean isShoppingCartEmpty() {
        new WebDriverWait(driver, 1)
            .until((WebDriver driver1) -> driver1.findElement(SHOPPING_CART_EMPTY_LABEL).isDisplayed());
        return driver.findElement(SHOPPING_CART_EMPTY_LABEL).isDisplayed();
    }
}
