package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.CheckBoxPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckBoxTest {
    CheckBoxPage checkBoxPage = new CheckBoxPage();
    SoftAssert softAssert = new SoftAssert();
    @Test//checkboxes
    public void checkBoxTestSoftAssert() {
        //1. Navigate to "https://practice.cydeo.com/checkboxes"
        Driver.get().get("https://practice.cydeo.com/checkboxes");

        //2. Checbox1 is not selected by default
        softAssert.assertTrue(!checkBoxPage.checkBox1.isSelected());

        //3. Confirm checkbox2 is selected by default
        softAssert.assertTrue(checkBoxPage.checkBox2.isSelected());

        //4. Click checkbox1 to select it
        checkBoxPage.checkBox1.click();
        softAssert.assertTrue(checkBoxPage.checkBox1.isSelected());

        //5. Click on checkbox2 to deselect it
        checkBoxPage.checkBox2.click();
        softAssert.assertTrue(!checkBoxPage.checkBox2.isSelected());

        softAssert.assertAll();

    }

    @Test
    public void checkBoxTest() {
        //1. Navigate to "https://practice.cydeo.com/checkboxes"
        Driver.get().get("https://practice.cydeo.com/checkboxes");

        //2. Checkbox1 is not selected by default
        Assert.assertTrue(!checkBoxPage.checkBox1.isSelected());

        //3. Confirm checkbox2 is selected by default
        Assert.assertTrue(checkBoxPage.checkBox2.isSelected());

        //4. Click checkbox1 to select it
        checkBoxPage.checkBox1.click();
        Assert.assertTrue(checkBoxPage.checkBox1.isSelected());

        //5. Click on checkbox2 to deselect it
        checkBoxPage.checkBox2.click();
        Assert.assertTrue(!checkBoxPage.checkBox2.isSelected());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

}
