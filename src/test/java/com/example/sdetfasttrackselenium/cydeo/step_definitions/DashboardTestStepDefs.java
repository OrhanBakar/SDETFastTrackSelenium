package com.example.sdetfasttrackselenium.cydeo.step_definitions;

import com.example.sdetfasttrackselenium.cydeo.pages.DashboardPage;
import com.example.sdetfasttrackselenium.cydeo.pages.VyTrackLoginPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DashboardTestStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));

    VyTrackLoginPage vyTrackLoginPage = new VyTrackLoginPage();

    @Then("user should be able to see options")
    public void user_should_be_able_to_see_options(List<String> menuOpts) {
        wait.until(ExpectedConditions.titleIs("Dashboard"));
        List<String> actualMenu = new ArrayList<>();
        for (WebElement menu : dashboardPage.menus) {
            actualMenu.add(menu.getText());

        }
        Assert.assertEquals(menuOpts, actualMenu);

    }

    @When("user choose {string}")
    public void user_choose(String roleName) throws IOException {

        String path = "VytrackData.xlsx";//provide file path
        FileInputStream fis = new FileInputStream(path);//opens your file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);//use your file
        XSSFSheet sheet = workbook.getSheet("vytrack");//use the specific sheet
        String username = "";
        String password = "";
        switch (roleName) {
            case "Sales":
                username = sheet.getRow(10).getCell(0).toString();
                password = sheet.getRow(10).getCell(1).toString();
                break;
            case "Store":
                username = sheet.getRow(6).getCell(0).toString();
                password = sheet.getRow(6).getCell(1).toString();
                break;
        }
        vyTrackLoginPage.userNameInput.sendKeys(username);
        vyTrackLoginPage.passwordInput.sendKeys(password);
        vyTrackLoginPage.submitBtn.click();


    }

    @Then("user should be able to see options printed")
    public void user_should_be_able_to_see_options_printed() {
        System.out.println("User sees the navigation options");


    }

}
