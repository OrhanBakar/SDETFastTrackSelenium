package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.IFramesPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IFramesTest {
    @BeforeMethod
    public void setUp() {
        //1. Go to https://practice.cydeo.com/javascript_alerts
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().get("https://practice.cydeo.com/iframe");
    }
    IFramesPage iFramesPage=new IFramesPage();
    @Test
    public void iFrameTest(){
        Driver.get().switchTo().frame(0);
        //Driver.get().switchTo().frame("mce_0_ifr");
        //Driver.get().switchTo().frame(iFramesPage.iFrame);

        //2. Assert: "Your content goes here" text is displayed
        String actualText= iFramesPage.contentTextArea.getText();
        String expectedText="Your content goes here.";
        Assert.assertEquals(actualText,expectedText);

        //4. Switch back to default frame
        Driver.get().switchTo().defaultContent();

        //3. Assert an iframe contains "TinyMCE WYSIWYG Editor"
        String actualHeader=iFramesPage.headerText.getText();
        String expectedHeader="An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualHeader,expectedHeader);


    }



    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
