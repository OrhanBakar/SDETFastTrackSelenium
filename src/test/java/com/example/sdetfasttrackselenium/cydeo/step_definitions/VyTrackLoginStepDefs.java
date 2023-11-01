package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import com.example.sdetfasttrackselenium.cydeo.pages.VyTrackLoginPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.ConfigurationReader;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class VyTrackLoginStepDefs {
    WebDriver driver;
    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();
    WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(15));

    @Given("user goes to vytrack login page")
    public void user_goes_to_vytrack_login_page() {
        Driver.get().get("https://qa1.vytrack.com/user/login");

    }

    @When("user enters username and password and click login button")
    public void user_enters_username_and_password_and_click_login_button() {
        vyTrackLoginPage.userNameInput.sendKeys("user1");
        vyTrackLoginPage.passwordInput.sendKeys("UserUser123");
        vyTrackLoginPage.submitBtn.click();
    }

    @Then("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        String expectedTitle="Dashboard";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }



    }



