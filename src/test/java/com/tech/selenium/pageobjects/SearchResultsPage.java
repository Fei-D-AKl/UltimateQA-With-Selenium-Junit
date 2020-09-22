package com.tech.selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fei Deng on 21/09/20.
 */
public class SearchResultsPage {

    private WebDriver driver = null;

    @FindBy(partialLinkText = "How to fix Selenium")
    public WebElement lnkSelenium;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
