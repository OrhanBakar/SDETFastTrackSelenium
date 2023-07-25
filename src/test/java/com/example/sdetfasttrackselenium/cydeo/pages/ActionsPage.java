package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage {
    @FindBy(xpath = "(//img)[1]")
    public WebElement image1;

    @FindBy(xpath = "(//img)[2]")
    public WebElement image2;

    @FindBy(xpath = "(//img)[3]")
    public WebElement image3;

    @FindBy(xpath = "//*[text() = 'name: user1']")
    public WebElement NameUser1;

    @FindBy(xpath = "//*[text() = 'name: user2']")
    public WebElement NameUser2;

    @FindBy(xpath = "//*[text() = 'name: user3']")
    public WebElement NameUser3;

    @FindBy(linkText = "A/B Testing")
    public WebElement abTestLink;

    @FindBy(linkText = "CYDEO")
    public WebElement cydeoLink;

    @FindBy(linkText = "Home")
    public WebElement homeLink;


    public ActionsPage(){

        PageFactory.initElements(Driver.get(),this);
    }

}
