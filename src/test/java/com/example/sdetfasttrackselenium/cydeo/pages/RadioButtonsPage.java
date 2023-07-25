package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage {

    public RadioButtonsPage(){
        PageFactory.initElements(Driver.get(),this);
       
    }
    @FindBy(name = "color")
    public WebElement blueButton;

    @FindBy(name = "color")
    public WebElement redButton;

    @FindBy(name = "color")
    public WebElement yellowButton;

    @FindBy(name = "color")
    public WebElement blackButton;

    @FindBy(name = "color")
    public WebElement greenButton;

    @FindBy(name = "sport")
    public WebElement basketballButton;

    @FindBy(name = "sport")
    public WebElement footballButton;

    @FindBy(name = "sport")
    public WebElement hockeyButton;

    @FindBy(name = "sport")
    public WebElement waterPoloButton;

    @FindBy(xpath = "//*[text() = 'Radio buttons']")
    public WebElement radioButtonsText;

    @FindBy(css = "h6")
    public WebElement selectYourFavoriteColorText;

    @FindBy(xpath = "//*[text() = 'Select your favorite sport:']")
    public WebElement selectYourFavoriteSportText;

    @FindBy(xpath = "//*[text() = 'Powered by CYDEO']")
    public WebElement poweredCydeoText;

    @FindBy(xpath = "//a[@target='_blank']")
    public WebElement linkCydeo;


    


}
