package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.JavaFakerPage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class JavaFakerTest {
    Faker faker=new Faker();
    JavaFakerPage javaFakerPage = new JavaFakerPage();
    WebDriverWait wait=new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
    @Test
    public void javaFakerTest(){
        Driver.get().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        javaFakerPage.username.sendKeys("Tester");
        javaFakerPage.password.sendKeys("test");
        javaFakerPage.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(javaFakerPage.orderLink));
        javaFakerPage.orderLink.click();
        Select productSelect=new Select(javaFakerPage.productDropdown);
        productSelect.selectByVisibleText("FamilyAlbum");
        javaFakerPage.quantityBox.sendKeys("5");
        javaFakerPage.calculateButton.click();
        javaFakerPage.customerNameBox.sendKeys(faker.name().username());
        javaFakerPage.streetBox.sendKeys(faker.address().streetName());
        javaFakerPage.cityBox.sendKeys(faker.address().city());
        javaFakerPage.zipBox.sendKeys(faker.address().zipCode().replace("-",""));
        javaFakerPage.visaRadioButton.click();
        javaFakerPage.cardNumberBox.sendKeys(faker.business().creditCardNumber().replace("-",""));
        javaFakerPage.expiryDateBox.sendKeys(faker.business().creditCardExpiry().substring(0,2)+ "/"
                + faker.business().creditCardExpiry().substring(2));
        javaFakerPage.processButton.click();
        Assert.assertEquals(javaFakerPage.orderConfirmMessage.getText(),"New order has been successfully added.");

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}
