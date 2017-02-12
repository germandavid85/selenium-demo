package org.seleniumdemo.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumdemo.pageobject.HomePage;
import org.seleniumdemo.pageobject.SearchResultPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        String browserName = System.getProperty("browserName");

        if (browserName != null && browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();

        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchDressAndValidateResults() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.loadHomePage();
        homePage.search("dress");

        boolean isDressDisplayed = searchResultPage.isResultItemDisplayed("Printed Chiffon Dress");
        assertTrue(isDressDisplayed);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
