package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    @FindBy(name = "username")
    public WebElement usernameBox;

    @FindBy(name = "password")
    public WebElement passwordBox;

    @FindBy(css = "button[class$='submit']")
    public WebElement loginButton;


    public WebTableLoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
