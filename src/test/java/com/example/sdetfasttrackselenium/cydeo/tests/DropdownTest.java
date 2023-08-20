package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.DropdownPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest {

    DropdownPage dropdownPage=new DropdownPage();
    @BeforeMethod
    public void setUp(){
        //1. Go to https://practice.cydeo.com/dropdown

        Driver.get().get("https://practice.cydeo.com/dropdown");
    }
    @Test

    public void stateDropdownTest(){
        // TC#1
        //stateSelect objesine dropdown'in locatorini assign ediyorum
        Select stateSelect=new Select(dropdownPage.stateDropdown);
        //2. Select Illinois --> select by visible text
        stateSelect.selectByVisibleText("Illinois");
        //getFirstSelectedOption() bize en son sectigimiz optionu verir. Bunu alamak icin de
        //getText() metodunu kullaniriz
        String actualOption=stateSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Illinois");

        //3. Select Virginia --> select by value
        stateSelect.selectByValue("VA");
        actualOption=stateSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Virginia");

        //4. Select California --> select by index
        stateSelect.selectByIndex(5);
        actualOption=stateSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"California");

        //5. Select all the states and confirm that Illinois exist in the options
        dropdownPage.dropdownOptionsCheck(dropdownPage.stateDropdown,"Illinois");
    }


    @Test

    public void dateOfBirthDropdownTest(){
    //TC#2
        //1. Select "December 1st 1950g" and verify it is selected

        //2. Select year --> by visible text
        Select yearSelect=new Select(dropdownPage.yearDropdown);
        yearSelect.selectByVisibleText("1950");
        String actualYearOption=yearSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYearOption,"1950","Year select did not pass!");
        //3. Select Month --> by value
        Select monthSelect=new Select(dropdownPage.monthDropdown);
        monthSelect.selectByValue("11");
        String actualMontOption=monthSelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMontOption,"December","Month select did not pass!");
        //4. Select Day --> by index
        Select daySelect=new Select(dropdownPage.dayDropdown);
        daySelect.selectByIndex(0);
        String actualDayOption=daySelect.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDayOption,"1","Day select did not pass!");

    }
@Test
    public void languageDropdownTest(){
        //TC#3
    Select languagesSelect=new Select(dropdownPage.languagesDropdown);
    List<WebElement>languagesOptions=languagesSelect.getOptions();
    //2. Select all the options from multiple language select dropdown
    //3. Print out all the selected values and verify each is selected
    for (WebElement eachOption : languagesOptions) {
        languagesSelect.selectByVisibleText(eachOption.getText());
        System.out.println("Programming language Options = " + eachOption.getText());
        Assert.assertTrue(eachOption.isSelected(),"Language option did not selected");
    }

    //4. Deselect all values and verify each is deselected
    
    languagesSelect.deselectAll();
    for (WebElement eachOption : languagesOptions) {
        Assert.assertFalse(eachOption.isSelected());
    }
}

@AfterMethod
    public void tearDown(){
    Driver.closeDriver();
}
}
