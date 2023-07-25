package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.ActionsPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.BrowserUtils;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsTest {

    ActionsPage actionsPage = new ActionsPage();
    Actions actions = new Actions(Driver.get());
    @Test

    public void hoverOverTest() {

        //TC#1
        //Navigate to https://practice.cydeo.com/hovers
        Driver.get().get("https://practice.cydeo.com/hovers");


        //2. Hover over the first image
        actions.moveToElement(actionsPage.image1).perform();

        //3. Assert: "name user1" is displayed
        Assert.assertTrue(actionsPage.NameUser1.isDisplayed(), "Name 1 didn't appear");

        //4. Hover over the second image
        actions.moveToElement(actionsPage.image2).perform();

        //5. Assert "name user2" is displayed
        Assert.assertTrue(actionsPage.NameUser2.isDisplayed(), "Name 2 didn't appear");

        //6. Hover over third image
        actions.moveToElement(actionsPage.image3).perform();

        //Assert "name user3" is displayed
        Assert.assertTrue(actionsPage.NameUser3.isDisplayed(), "Name 3 didn't appear");

    }

    @Test

    public void rightClickTest(){

        //TC#2
        //1. Navigate to https://practice.cydeo.com/
        Driver.get().get("https://practice.cydeo.com/");

        //2. Right-click on the A/B Testing link
        //3. Open link in new window
        actions.contextClick(actionsPage.abTestLink)
                .sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN).perform();//Keys.Return ü secmesi icin kullaniyoruz

        //4. Verify title is "No A/B Test"
        Assert.assertEquals(Driver.get().getTitle(),"No A/B Test");
    }

    @Test
    public void jsExecutorScrollingTest(){
       //TC#3
        //1. Navigate to https://practice.cydeo.com/
        Driver.get().get("https://practice.cydeo.com/");

        JavascriptExecutor js= ((JavascriptExecutor) Driver.get());
        //2. Scroll-down to "Cydeo" link
        js.executeScript("arguments[0].scrollIntoView(true)",actionsPage.cydeoLink,actionsPage.homeLink);
        BrowserUtils.waitFor(2);
        //3. Scroll-up to "Home" link
        js.executeScript("arguments[1].scrollIntoView(true)",actionsPage.cydeoLink,actionsPage.homeLink);


    }

}
