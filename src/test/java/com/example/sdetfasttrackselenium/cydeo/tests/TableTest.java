package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.TablesPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TableTest {
    TablesPage tablesPage=new TablesPage();
    @BeforeMethod
    public void setUp(){
        //1. Navigate to the "https://practice.cydeo.com/tables"
        Driver.get().get("https://practice.cydeo.com/tables");
        WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("tables"));
    }
   @Test
   public void variableTestInWebTable(){
       boolean isNamePresent=tablesPage.isNamePresent("Frank", "Bach");
       Assert.assertTrue(isNamePresent,"Frank Bach should exist in the table");
   }
   @Test
   public void testGetAllDataForFullName(){
        tablesPage.getAllDataForFullName("Jason","Doe");

   }

    @Test
   public void getAllEmails(){
       List<String> emailAddresses=tablesPage.getAllEmailAddresses();
       for (String email:emailAddresses){
           System.out.println("Email = " + email);
       }
   }
   @Test
   public void getAllWebAddresses(){
        List<String> webAddresses=tablesPage.getAllWebAddresses();
        for (String webAddress:webAddresses){
            System.out.println("webAddress = " + webAddress);
        }
   }
    @AfterMethod
    public void tearDown() {
        if (Driver.get() != null) {
            Driver.closeDriver();
        }
    }
}
