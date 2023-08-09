package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import com.example.sdetfasttrackselenium.cydeo.pages.GoogleSearchPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class GoogleSearchStepdefs {

    GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @Given("user is on  google home page")
    public void userIsOnGoogleHomePage() {
        Driver.get().get("https://google.com");

    }

    @When("user searches for {string} capital")
    public void userSearchesForCapital(String country) {
        googleSearchPage.searchBox.sendKeys("Capital city of"+country+ Keys.ENTER);
    }

    @Then("user should see the {string} result")
    public void userShouldSeeTheResult(String capital) {
        Assert.assertEquals(capital,googleSearchPage.linkCapital.getText());

    }
}
