package com.tech.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Fei Deng on 21/09/20.
 */
public class UltimateQaPage {

    private WebDriver driver = null;


    public UltimateQaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openURL(){
        driver.get("https://ultimateqa.com/automation/");
    }

}
