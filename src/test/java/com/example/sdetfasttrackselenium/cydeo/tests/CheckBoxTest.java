package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.CheckBoxPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckBoxTest {
    CheckBoxPage checkBoxPage=new CheckBoxPage();

    @Test
    public void checkBoxTest(){
        Driver.get().get("https://practice.cydeo.com/checkboxes");
        checkBoxPage.checkBox1.click();
        Assert.assertTrue(checkBoxPage.checkBox1.isSelected());
        checkBoxPage.checkBox1.click();
        Assert.assertFalse(checkBoxPage.checkBox1.isSelected(),"Checkbox 1 is not selected");
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
