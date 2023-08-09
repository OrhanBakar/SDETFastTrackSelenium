package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import com.example.sdetfasttrackselenium.cydeo.pages.WebTableLoginPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.ConfigurationReader;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebTableLoginStepdefs {
    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    @Given("user is on the login page of the webtable app")
    public void userIsOnTheLoginPageOfTheWebtableApp() {
        Driver.get().get(ConfigurationReader.get("env"));
    }

    @When("user enters username Test")
    public void userEntersUsernameTest() {
        webTableLoginPage.usernameBox.sendKeys(ConfigurationReader.get("username"));
    }

    @And("user enters password Tester")
    public void userEntersPasswordTester() {
        webTableLoginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
    }

    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains order")
    public void userShouldSeeUrlContainsOrder() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("orders"));
    }

    @When("user enters invalid username")
    public void userEntersInvalidUsername() {
        webTableLoginPage.usernameBox.sendKeys("incorrect");
    }

    @And("user enters invalid password")
    public void userEntersInvalidPassword() {
        webTableLoginPage.passwordBox.sendKeys("incorrect");
    }

    @Then("user should see url contains login")
    public void userShouldSeeUrlContainsLogin() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("login"));
    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        webTableLoginPage.usernameBox.sendKeys(username);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        webTableLoginPage.passwordBox.sendKeys(password);
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        webTableLoginPage.login(username,password);
    }

    @When("user enters the credentials below")
    public void userEntersTheCredentialsBelow(Map<String,String>credentials) {
        //Böyle de olur.Datatable daki bilgilere bu sekilde ulasabilirsin
        webTableLoginPage.login(credentials.get("username"),credentials.get("password"));
       /* Böyle de olur
        webTableLoginPage.usernameBox.sendKeys(credentials.get("username"));
        webTableLoginPage.passwordBox.sendKeys(credentials.get("password"));
        webTableLoginPage.loginButton.click();
        */

    }
}
