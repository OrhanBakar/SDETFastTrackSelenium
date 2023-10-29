package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    @FindBy(css = "button[onclick='jsAlert()']")
    public WebElement buttonClickForAlert;

    @FindBy(css = "button[onclick='jsConfirm()']")
    public WebElement buttonClickForConfirm;

    @FindBy(id = "result")
    public WebElement resultText;

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    public WebElement jsAlertButton;


    public AlertPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
