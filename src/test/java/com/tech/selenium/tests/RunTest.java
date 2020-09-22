package com.tech.selenium.tests;

import com.tech.selenium.driverutil.DriverFactory;
import com.tech.selenium.pageobjects.UltimateQaPage;
import com.tech.selenium.pageobjects.SearchResultsPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Fei Deng on 21/09/20.
 */
public class RunTest {

    private WebDriver driver;
    UltimateQaPage ultimateQaPage;
    SearchResultsPage searchResultsPage;

    @Before
    public void setUp(){
        driver = DriverFactory.getBrowser();
        ultimateQaPage = new UltimateQaPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void Search() throws InterruptedException {
        driver.manage().window().maximize();
        ultimateQaPage.openURL();
        Actions build = new Actions(driver);
        build.moveToElement(driver.findElement(By.id("et_search_icon"))).moveByOffset(10, 0).click().build().perform();
        driver.findElement(By.id("jetpack-instant-search__box-input-1")).sendKeys("Selenium");
        Thread.sleep(3000);
        Assert.assertTrue(searchResultsPage.lnkSelenium.isDisplayed());
    }

    @Test
    public void OpenLinkFromTopManualBar() throws InterruptedException {
        driver.manage().window().maximize();
        ultimateQaPage.openURL();
        driver.findElement(By.xpath("//*[@id='menu-item-504']/a")).click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://courses.ultimateqa.com/");
    }

    @Test
    public void OpenLinkFromPageLink() throws InterruptedException {
        driver.manage().window().maximize();
        ultimateQaPage.openURL();
        driver.findElement(By.xpath("//*[@id='et-boc']/div/div/div[2]/div/div[1]/div/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(3000);
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://ultimateqa.com/complicated-page/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
