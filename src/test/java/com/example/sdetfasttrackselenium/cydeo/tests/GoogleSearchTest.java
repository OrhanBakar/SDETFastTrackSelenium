package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.GoogleSearchPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.ConfigurationReader;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GoogleSearchTest {
GoogleSearchPage googleSearchPage=new GoogleSearchPage();
    @Test
    public void googleSearchTest() throws InterruptedException {
      Driver.get().get(ConfigurationReader.get("googleUrl"));
      googleSearchPage.acceptButton.click();
        Thread.sleep(200);
      googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
        Assert.assertEquals(Driver.get().getTitle(),"apple - Google Search");
    }
    @Test
    public void hardAssertionTest() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("googleUrl"));
        //googleSearchPage.acceptButton.click();
        Thread.sleep(200);
        googleSearchPage.searchBox.sendKeys("app" + Keys.ENTER);
        Assert.assertEquals(Driver.get().getTitle(),"apple - Google Search");
        System.out.println("This only comes if hard assertion fails");
    }

    @Test
    public void softAssertionTest() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("googleUrl"));
        //googleSearchPage.acceptButton.click();
        Thread.sleep(200);
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(Driver.get().getTitle(),"app - Google Search");
        System.out.println("This only comes if soft assertion fails");
        //softAssert.assertAll();
    }
}
