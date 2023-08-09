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

        radioButtonsPage.yellowButton.click();

       /* Assert.assertTrue(radioButtonsPage.blueButton.isSelected(),"Blue button is selected");

        Assert.assertFalse(radioButtonsPage.footballButton.isSelected(),"Football button is not selected");

        radioButtonsPage.footballButton.click();

        Assert.assertTrue(radioButtonsPage.footballButton.isSelected(),"Football button is selected");

        radioButtonsPage.redButton.click();

        Assert.assertTrue(radioButtonsPage.redButton.isSelected(),"Red button is selected");

        Assert.assertTrue(radioButtonsPage.blueButton.isSelected(),"Blue button is selected");

        Assert.assertTrue(radioButtonsPage.greenButton.isEnabled(),"Green button is not enabled");*/
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
