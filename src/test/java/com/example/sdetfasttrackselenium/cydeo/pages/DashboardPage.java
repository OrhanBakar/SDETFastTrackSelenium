package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(xpath="//span[@class='title title-level-1']")
    public List<WebElement> menus;


    public DashboardPage() {
        PageFactory.initElements(Driver.get(),this);
    }


}
