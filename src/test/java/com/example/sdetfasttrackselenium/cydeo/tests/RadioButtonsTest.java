package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.RadioButtonsPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RadioButtonsTest {
    RadioButtonsPage radioButtonsPage=new RadioButtonsPage();

    @Test
    public void radioButtonTest(){
        Driver.get().get("https://practice.cydeo.com/radio_buttons");

        radioButtonsPage.blueButton.click();

        Assert.assertTrue(radioButtonsPage.blueButton.isSelected());

        Assert.assertTrue(!radioButtonsPage.footballButton.isSelected());

        radioButtonsPage.footballButton.click();

        Assert.assertTrue(radioButtonsPage.footballButton.isSelected());

        radioButtonsPage.redButton.click();

        Assert.assertTrue(radioButtonsPage.redButton.isSelected());

        Assert.assertTrue(!radioButtonsPage.blueButton.isSelected());

        //Assert.assertTrue(radioButtonsPage.greenButton.isEnabled(),"Green Button is disabled");
        Assert.assertTrue(!radioButtonsPage.greenButton.isEnabled(),"Green Button is enabled");
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
