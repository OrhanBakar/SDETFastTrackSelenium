package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.AlertPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {

    AlertPage alertPage = new AlertPage();
    Alert alert = Driver.get().switchTo().alert();

    @BeforeMethod
    public void setUp() {
        //1. Go to https://practice.cydeo.com/javascript_alerts
        Driver.get().get("https://practice.cydeo.com/javascript_alerts");

    }

    @Test
    public void jsAlertTest() throws InterruptedException {

        //2. Click for JS Prompt button for alert to be displayed
        alertPage.jsAlertButton.click();

        //3. Write "Hello" in input text
        alert.sendKeys("Hello");

        //4. Click OK button from the alert
        alert.accept();
        String actualResultText=alertPage.resultText.getText();
        String expectedResultText="You entered: Hello";
        Assert.assertEquals(actualResultText,expectedResultText);


    }

   @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
