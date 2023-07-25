package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage {
    @FindBy(id = "state")
    public WebElement stateDropdown;

    @FindBy(id = "year")
    public WebElement yearDropdown;

    @FindBy(id = "month")
    public WebElement monthDropdown;

    @FindBy(id = "day")
    public WebElement dayDropdown;

    @FindBy(css = "select[id='dropdown']")
    public WebElement simpleDropdown;

    @FindBy(name = "Languages")
    public WebElement languagesDropdown;

    @FindBy(id = "dropdownMenuLink")
    public WebElement linkDropdown;


    public DropdownPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    
    
}
