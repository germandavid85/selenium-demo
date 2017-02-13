package org.seleniumdemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class CategoryPage {
    @FindBy(linkText = "Tops")
    private WebElement topCategory;

    public CategoryPage(final WebDriver driver) {
        Objects.requireNonNull(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToTopSubCategory() {
        topCategory.click();
    }
}
