package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){
        System.out.println("Setting up browser using cucumber before each scenario");
    }

    @Before(value="@db")
    public void setUpDatabaseScenario(){
        System.out.println("Setting up database using cucumber before each scenario");
    }
    @After
    public void tearDownScenario(Scenario scenario){
        //System.out.println("It will be closing browser using cucumber after each scenario");
        if (scenario.isFailed()){
            byte[] screenshot=((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
