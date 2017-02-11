package org.seleniumdemo.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ProjectsTest {

    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://www.seleniumhq.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSeleniumTestCase() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.id("menu_projects")).click();
        driver.findElement(By.linkText("Selenium WebDriver")).click();
        String webDriverTitle = driver.findElement(By.cssSelector("#mainContent h2")).getText();
        assertEquals("Selenium WebDriver", webDriverTitle);

        driver.findElement(By.id("menu_projects")).click();
        driver.findElement(By.linkText("Selenium Grid")).click();
        String gridTitle = driver.findElement(By.cssSelector("#mainContent h2")).getText();
        assertEquals("Selenium Grid", gridTitle);

        driver.findElement(By.id("menu_projects")).click();
        driver.findElement(By.linkText("Selenium IDE")).click();
        boolean isPluginLinkDisplayed = driver.findElement(By.linkText("Selenium IDE Plugins")).isDisplayed();
        assertTrue(isPluginLinkDisplayed);

        driver.findElement(By.id("menu_projects")).click();
        driver.findElement(By.linkText("Selenium Remote Control")).click();
        boolean isRCImageDisplayed = driver.findElement(By.cssSelector("img[alt='rc arch diagram']")).isDisplayed();
        assertTrue(isRCImageDisplayed);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
