package org.seleniumdemo.common;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

class BrowserFactory {
    static WebDriver getBrowser(String browserName) {
        WebDriver driver;
        if (browserName != null && browserName.equals("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();

        } else {
            MarionetteDriverManager.getInstance().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }

    static DesiredCapabilities getRemoteCapabilities(String browserName) {
        DesiredCapabilities capabilities;
        if (browserName != null && browserName.equals("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("version", "55.0");

        } else if (browserName != null && browserName.equals("ie")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability("platform", "Windows 7");
            capabilities.setCapability("version", "11.0");
        }
        else {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("version", "46.0");
        }
        return capabilities;
    }
}
