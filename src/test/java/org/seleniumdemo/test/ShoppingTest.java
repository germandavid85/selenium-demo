package org.seleniumdemo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumdemo.pageobject.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ShoppingTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addShortsToCartValidatePriceAndCleanCart() throws Exception {
        HomePage homePage = new HomePage(this.driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        SubCategoryPage subCategoryPage = new SubCategoryPage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        homePage.loadHomePage();
        homePage.goToWomenSubcategory();

        categoryPage.goToTopSubCategory();

        String productName = "Faded Short Sleeve T-shirts";
        subCategoryPage.goToProductDetails(productName);

        productDetailPage.addProductToCart();
        String totalPrice = checkoutPage.getTotalPrice();
        assertEquals("$18.51", totalPrice);

        checkoutPage.cleanShoppingCart();
        boolean isCartEmpty = checkoutPage.isShoppingCartEmpty();
        assertTrue(isCartEmpty);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
