package com.example.sdetfasttrackselenium.cydeo.tests;

import com.example.sdetfasttrackselenium.cydeo.pages.WindowHandlePracticePage;
import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandlePracticeTest {

    WindowHandlePracticePage windowHandlePracticePage=new WindowHandlePracticePage();

    @Test
    public void windowHandleTest(){
        //1. Navigate to: "https://practice.cydeo.com/windows"
        Driver.get().get("https://practice.cydeo.com/windows");

        //Öncelikle ilk acilan windowsu bir variable a kaydediyoruz
        String currentWindow=Driver.get().getWindowHandle();
        System.out.println("currentWindow = " + currentWindow);

        //2. Assert the title is "Windows"
        Assert.assertEquals(Driver.get().getTitle(),"Windows");

        //3. Clich to "Click Here" link
        windowHandlePracticePage.clickHereLink.click();
        String clickHereWindow=Driver.get().getWindowHandle();
        System.out.println("clickHereWindow = " + clickHereWindow);

        //4. Click to "Cydeo" link
        windowHandlePracticePage.cydeoLink.click();
        String cydeoWindow=Driver.get().getWindowHandle();
        System.out.println("cydeoWindow = " + cydeoWindow);

        //Sonra bir Set olusturarak tüm pencereleri buraya kaydediyoruz
        Set<String> allWindowsHandle=Driver.get().getWindowHandles();

        //5. Switch to Cydeo page

        //Daha sonra pencere bilgilerini loop olusturarak bir variabla kaydediyoruz
        for (String eachWindow : allWindowsHandle) {
            //Daha sonra herbir pencereye tek tek switch yapiyoruz
            Driver.get().switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

            //Istedigimiz belirli bir sayfa varsa if olusturarak o sayfaya gelince durmasini istiyoruz
            if (Driver.get().getTitle().equals("Cydeo")){
                break;
            }

        }
        //6. Assert: Title is "Cydeo"
        Assert.assertEquals(Driver.get().getTitle(),"Cydeo");

        //7. Switch back to main handle
        Driver.get().switchTo().window(currentWindow);
        Assert.assertEquals(Driver.get().getTitle(),"Windows");


    }


}
