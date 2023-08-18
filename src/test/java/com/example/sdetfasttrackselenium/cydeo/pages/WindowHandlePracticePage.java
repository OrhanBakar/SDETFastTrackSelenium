package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowHandlePracticePage {

    public WindowHandlePracticePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(linkText = "Click Here")
    public WebElement clickHereLink;

    @FindBy(linkText = "CYDEO")
    public WebElement cydeoLink;

}
