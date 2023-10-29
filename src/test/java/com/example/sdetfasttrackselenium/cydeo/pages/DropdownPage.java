package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

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
        Select dropdownOptions=new Select(locator);
        boolean expectedOption=false;
        for (WebElement dropdownOption:dropdownOptions.getOptions()){//Tüm optionlari görüntüledik
           //System.out.println("State options = " + stateOption.getText());
            if (dropdownOption.getText().equals(option)){
                expectedOption=true;
                break;
            }

        }
        //Assert.assertEquals(option,expectedOption);
        Assert.assertTrue(expectedOption,"Dropdown does not contain:"+option);
        System.out.println("Expected option = " + option+" exists");
    }

    public void getDropdownOptions(WebElement locator) {
        Select select=new Select(locator);
        List<WebElement> options=select.getOptions();
        for (WebElement option : options) {
            select.selectByVisibleText(option.getText());
            System.out.println("Dropdown Option = " + option.getText());
            Assert.assertTrue(option.isSelected());
        }


    }

    public DropdownPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    
    
}
