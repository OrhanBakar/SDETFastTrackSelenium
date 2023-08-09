package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

public class GoogleSearchPage {


    public GoogleSearchPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(id="L2AGLb")
    public WebElement acceptButton;

    @FindBy(xpath = "//div[@class='kp-header']//a[class='FLP8od']")
    public WebElement linkCapital;




}
