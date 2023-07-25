package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaFakerPage {
    @FindBy(css = "input[id$='username']")
    public WebElement username;

    @FindBy(css = "input[id$='password']")
    public WebElement password;

    @FindBy(css = "input[id$='button']")
    public WebElement loginButton;

    @FindBy(linkText = "Order")
    public WebElement orderLink;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement productDropdown;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantityBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerNameBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement streetBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement cityBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBox;

    @FindBy(css = "input[id$='0']")
    public WebElement visaRadioButton;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBox;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expiryDateBox;

    @FindBy(css = "a[id*='fmwOrder']")
    public WebElement processButton;

    @FindBy(css = "input[onclick='UpdateFields()']")
    public WebElement resetButton;

    @FindBy(css = "input[value='Calculate']")
    public WebElement calculateButton;

    @FindBy(xpath = "//strong[normalize-space(text())='New order has been successfully added.']")
    public WebElement orderConfirmMessage;

    public JavaFakerPage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
