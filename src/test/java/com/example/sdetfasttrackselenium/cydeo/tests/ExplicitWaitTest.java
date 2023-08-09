package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.ExplicitWaitPracticePage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ExplicitWaitTest {
    ExplicitWaitPracticePage explicitWaitPracticePage=new ExplicitWaitPracticePage();
    WebDriverWait wait=new WebDriverWait(Driver.get(),15);
    @Test
    public void dynamicLoad1(){

        //TC#!
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.get().get("https://practice.cydeo.com/dynamic_loading/1");
        //2. Click to start
        explicitWaitPracticePage.startButton.click();
        //3. Wait until loading bar disappears

        wait.until(ExpectedConditions.visibilityOf(explicitWaitPracticePage.usernameBox));
        //4. Assert username inputbox is displayed
        Assert.assertTrue(explicitWaitPracticePage.usernameBox.isDisplayed());
        //5. Enter username: tomsmith
        explicitWaitPracticePage.usernameBox.sendKeys("tomsmith");
        //6. Enter password: incorrectpassword
        explicitWaitPracticePage.passwordBox.sendKeys("qwertz");
        //7. Click to submit button
        explicitWaitPracticePage.submitButton.click();
        //8. Assert "Your password is invalid!" text is displayed.
        Assert.assertTrue(explicitWaitPracticePage.errorMessage.isDisplayed());
    }
    @Test
    public void dynamicLoad7(){
        //TC#2
        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.get().get("https://practice.cydeo.com/dynamic_loading/7");
        //2. Wait until title is "Dynamic Title"
        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        //3. Assert : Message "Done" is displayed
        Assert.assertTrue(explicitWaitPracticePage.messageDone.isDisplayed());
        //4. Assert : Image is displayed
        Assert.assertTrue(explicitWaitPracticePage.image.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
