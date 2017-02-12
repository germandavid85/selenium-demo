package org.seleniumdemo.test;

import org.junit.Test;
import org.seleniumdemo.common.BaseTest;
import org.seleniumdemo.pageobject.*;

import static org.junit.Assert.*;

public class ShoppingTest extends BaseTest {

    @Test
    public void addShortsToCartValidatePriceAndCleanCart() throws Exception {
        HomePage homePage = new HomePage(driver);
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
}
