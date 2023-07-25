package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplicitWaitPracticePage {

    @FindBy(css = "button.btn.btn-primary")
    public WebElement startButton;

    @FindBy(id = "username")
    public WebElement usernameBox;

    @FindBy(id = "pwd")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text() = 'Done!']")
    public WebElement messageDone;

    @FindBy(xpath = "//img")
    public WebElement image;

    @FindBy(id = "flash")
    public WebElement errorMessage;



    public ExplicitWaitPracticePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
