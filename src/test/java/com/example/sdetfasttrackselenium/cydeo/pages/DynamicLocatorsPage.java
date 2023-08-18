package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLocatorsPage {
    @FindBy(xpath = "//div[normalize-space(text()) = 'locators']")
    public WebElement divBlogPostBody;


    public DynamicLocatorsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
