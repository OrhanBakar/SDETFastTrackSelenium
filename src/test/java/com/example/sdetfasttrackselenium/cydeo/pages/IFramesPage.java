package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramesPage {
    @FindBy(xpath ="//p[.='Your content goes here.']")
    public WebElement contentTextArea;
    @FindBy(id = "mce_0_ifr")
    public WebElement iFrame;
    @FindBy(xpath = "//h3[contains(text(),'TinyMCE')]")
    public WebElement headerText;
    public IFramesPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
