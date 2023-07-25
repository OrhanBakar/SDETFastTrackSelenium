package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.FileUploadPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest {
    FileUploadPage fileUploadPage=new FileUploadPage();
    @Test
    public void fileUploadTest(){
        Driver.get().get("https://practice.cydeo.com/upload");
        fileUploadPage.chooseFileButton.sendKeys("C:/Users/obkr4/Downloads/truck-1.jpg");
        fileUploadPage.fileUploadSubmitButton.click();
        Assert.assertTrue(fileUploadPage.upLoadedFiles.isDisplayed());
        Assert.assertEquals(fileUploadPage.headerFileUploaded.getText(),"File Uploaded!");
    }
}
