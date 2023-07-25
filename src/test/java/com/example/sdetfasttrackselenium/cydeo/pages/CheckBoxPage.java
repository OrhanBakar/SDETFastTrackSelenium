package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    @FindBy(xpath = "//*[@id='box1']")
    public WebElement checkBox1;

    @FindBy(xpath = "//*[@id='box2']")
    public WebElement checkBox2;

    @FindBy(xpath = "//*[text() = 'Checkboxes']")
    public WebElement checkBoxHeader;

    @FindBy(css = "a[class='nav-link']")
    public WebElement linkHome;
    


    public CheckBoxPage(){
        PageFactory.initElements(Driver.get(),this);
        
    }
    
    

}
