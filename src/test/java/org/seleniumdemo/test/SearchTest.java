package org.seleniumdemo.test;

import org.junit.Test;
import org.seleniumdemo.common.Base;
import org.seleniumdemo.pageobject.HomePage;
import org.seleniumdemo.pageobject.SearchResultPage;

import static org.junit.Assert.assertTrue;

public class SearchTest extends Base {

    @Test
    public void searchDressAndValidateResults() {
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.loadHomePage();
        homePage.search("dress");

        boolean isDressDisplayed = searchResultPage.isResultItemDisplayed("Printed Chiffon Dress");
        assertTrue(isDressDisplayed);
    }
}
