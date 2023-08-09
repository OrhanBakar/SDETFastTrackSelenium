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

    public void login(String user_name,String pass_word){

        usernameBox.sendKeys(user_name);
        passwordBox.sendKeys(pass_word);
        loginButton.click();
    }
    public void login(){

        usernameBox.sendKeys("Test");
        passwordBox.sendKeys("Tester");
        loginButton.click();
    }


    public WebTableLoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }
}
