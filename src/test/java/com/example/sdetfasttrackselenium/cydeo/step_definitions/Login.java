package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import io.cucumber.java.en.*;
import io.cucumber.plugin.event.Node;

public class Login {
    @Given("user goes to login page")
    public void user_goes_to_login_page() {
        System.out.println("User navigates to login page");

    }
    @When("user enters valid credentials and click login button")
    public void user_enters_valid_credentials_and_click_login_button() {
        System.out.println("User enters username and password");
    }
    @Then("user should be on the dashboard")
    public void user_should_be_on_the_dashboard() {
        System.out.println("User is on the dashboard");
    }

}
