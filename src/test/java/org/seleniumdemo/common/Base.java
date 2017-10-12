package org.seleniumdemo.common;

import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.common.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base implements SauceOnDemandSessionIdProvider {
    private final static String USER_NAME = Utils.readPropertyOrEnv("SAUCE_USERNAME", "");
    private final static String ACCESS_KEY = Utils.readPropertyOrEnv("SAUCE_ACCESS_KEY", "");
    private static final String SELENIUM_URI = "@ondemand.saucelabs.com:443/wd/hub";
    private static final long SAUCELABS_ID = System.currentTimeMillis() % 100000;

    private String sessionId;
    protected WebDriver driver;

    @Rule
    public final TestName name = new TestName() {
        public String getMethodName() {
            return String.format("%s", super.getMethodName());
        }
    };

    @Before
    public void setUp() throws Exception {
        String browserName = System.getProperty("browserName");

        driver = BrowserFactory.getBrowser(browserName);

        this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();
        driver.manage().timeouts().implicitlyWait(Wait.EXPLICIT_WAIT, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Override
    public String getSessionId() {
        return this.sessionId;
    }
}