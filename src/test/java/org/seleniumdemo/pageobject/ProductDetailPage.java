package org.seleniumdemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumdemo.common.Wait;

import java.util.Objects;

public class ProductDetailPage {
    @FindBy(name = "Submit")
    private WebElement submitButton;

    private static final By CHECKOUT_BUTTON = By.cssSelector("a[title='Proceed to checkout']");

    private final WebDriver driver;

    public ProductDetailPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void addProductToCart() {
        submitButton.click();

        new WebDriverWait(driver, Wait.SHORT_WAIT)
            .until((WebDriver driver1) -> {
                WebElement checkoutButton = driver1.findElement(CHECKOUT_BUTTON);
                return checkoutButton != null && checkoutButton.isDisplayed();
            });

        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
