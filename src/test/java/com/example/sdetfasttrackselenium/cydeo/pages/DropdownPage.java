package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    public void dropdownOptionsCheck(WebElement locator,String option){
        Select stateSelect=new Select(locator);
        boolean expectedOption=false;
        for (WebElement stateOption:stateSelect.getOptions()){//Tüm optionlari görüntüledik
           //System.out.println("State options = " + stateOption.getText());
            if (stateOption.getText().equals(option)){
                expectedOption=true;
                break;
            }

        }
        Assert.assertTrue(expectedOption,"Dropdown does not contain:"+option);
        System.out.println("Expected option = " + option+" exists");
    }
    public DropdownPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    
    
}
