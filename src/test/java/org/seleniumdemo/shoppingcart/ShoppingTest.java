package org.seleniumdemo.shoppingcart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ShoppingTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://automationpractice.com/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testBlouseV1() throws Exception {
        Actions actions = new Actions(driver);

        driver.get(baseUrl + "/index.php");
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.linkText("Tops")).click();

        WebElement shortImage = driver.findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']"));
        actions.moveToElement(shortImage);
        actions.perform();
        shortImage.click();

        driver.findElement(By.name("Submit")).click();


        driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).click();

        String totalPrice = driver.findElement(By.id("total_price_container")).getText();
        assertEquals("$18.51", totalPrice);

        WebElement shoppingCartOption = driver.findElement(By.cssSelector("a[title='View my shopping cart']"));
        actions.moveToElement(shoppingCartOption);
        actions.perform();

        driver.findElement(By.cssSelector("a.ajax_cart_block_remove_link")).click();
        Thread.sleep(500);

        boolean isEmptyCartSpanDisplayed = driver.findElement(By.cssSelector(".ajax_cart_no_product")).isDisplayed();

        assertTrue(isEmptyCartSpanDisplayed);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
