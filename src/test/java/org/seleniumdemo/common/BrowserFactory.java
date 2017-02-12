package org.seleniumdemo.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class BrowserFactory {
    static WebDriver getBrowser( String browserName) {
        WebDriver driver;
        if (browserName != null && browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();

        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
