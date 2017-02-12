package org.seleniumdemo.shoppingcart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by gpotesf on 2/11/17.
 */
public class ShoppingTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://automationpractice.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testBlouseV1() throws Exception {
        driver.get(baseUrl + "/index.php");
        driver.findElement(By.linkText("Women")).click();
        driver.findElement(By.cssSelector("a.subcategory-name")).click();
        driver.findElement(By.cssSelector("a.product_img_link > img.replace-2x.img-responsive")).click();
        driver.findElement(By.name("Submit")).click();
        driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
        driver.findElement(By.cssSelector("a.ajax_cart_block_remove_link")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
