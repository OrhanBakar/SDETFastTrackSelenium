package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtonsPage {

    public RadioButtonsPage(){
        PageFactory.initElements(Driver.get(),this);
       
    }
    @FindBy(id= "blue")
    public WebElement blueButton;

    @FindBy(id = "red")
    public WebElement redButton;

    @FindBy(id = "yellow")
    public WebElement yellowButton;

    @FindBy(id = "black")
    public WebElement blackButton;

    @FindBy(id = "green")
    public WebElement greenButton;

    @FindBy(id = "basketball")
    public WebElement basketballButton;

    @FindBy(id = "football")
    public WebElement footballButton;

    @FindBy(id = "hockey")
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
