package org.seleniumdemo.pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class HomePage {
    @FindBy(linkText = "Women")
    private WebElement womenMenu;

    @FindBy(name = "search_query")
    private WebElement searchField;

    private final WebDriver driver;

    public HomePage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void goToWomenSubcategory() {
        womenMenu.click();
    }

    public void loadHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }

    public void search(String searchText) {
        Objects.requireNonNull(searchText);
        searchField.sendKeys(searchText);
        searchField.sendKeys(Keys.ENTER);
    }
}
