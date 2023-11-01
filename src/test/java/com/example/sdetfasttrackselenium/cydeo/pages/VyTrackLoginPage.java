package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VyTrackLoginPage {
    public VyTrackLoginPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement submitBtn;

}
