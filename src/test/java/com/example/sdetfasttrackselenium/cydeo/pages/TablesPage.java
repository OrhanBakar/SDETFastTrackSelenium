package com.example.sdetfasttrackselenium.cydeo.pages;

import com.example.sdetfasttrackselenium.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

import static org.testng.Assert.assertEquals;

public class TablesPage {
    @FindBy(id = "table1")
    private WebElement table1;

    @FindBy(xpath = "//table[@id='table1']//td[text()='jdoe@hotmail.com']/../td[.='Jason']")
    public WebElement firstNameJason;
    @FindBy(xpath = "//tbody/tr/td[1]")
    public List<WebElement> lastNames;
    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> firstNames;
    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> eMails;
    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> dueAmounts;
    @FindBy(xpath = "//tbody/tr/td[5]")
    public List<WebElement> webSites;

    @FindBy(css = "a")
    public WebElement linkEdit;

    @FindBy(css = "a.cell")
    public WebElement linkDelete;

    public boolean isNamePresent(String firstName, String lastName) {
        String locator = "//tr[td[normalize-space(.) = '" + firstName + "']" +
                " and td[normalize-space(.) = '" + lastName + "']]";
        ;
        return !table1.findElements(By.xpath(locator)).isEmpty();
    }

    public List<String> getAllEmailAddresses() {
        List<String> emailAddresses = new ArrayList<>();

        List<WebElement> emailCells = eMails;
        // Assuming email is in the third column
        for (WebElement cell : emailCells) {
            emailAddresses.add(cell.getText());
        }

        return emailAddresses;
    }

    public List<String> getAllLastNames() {
        List<String> lastName = new ArrayList<>();

        List<WebElement> lastNameCells = lastNames;
        // Assuming email is in the third column
        for (WebElement cell : lastNameCells) {
            lastName.add(cell.getText());
        }

        return lastName;
    }

    public List<String> getAllFirstNames() {
        List<String> firstName = new ArrayList<>();

        List<WebElement> firstNameCells = firstNames;
        // Assuming email is in the third column
        for (WebElement cell : firstNameCells) {
            firstName.add(cell.getText());
        }

        return firstName;
    }

    public List<String> getAllDueAmounts() {
        List<String> dueAmount = new ArrayList<>();

        List<WebElement> dueCells = dueAmounts;
        // Assuming email is in the third column
        for (WebElement cell : dueCells) {
            dueAmount.add(cell.getText());
        }

        return dueAmount;
    }

    public List<String> getAllWebAddresses() {
        List<String> webAddresses = new ArrayList<>();

        List<WebElement> webCells = webSites;
        // Assuming email is in the third column
        for (WebElement webCell : webCells) {
            webAddresses.add(webCell.getText());
        }

        return webAddresses;
    }

    public Map<String, String> getAllDataForFullName(String firstName, String lastName) {
        //Ilk adim formata karar verip ona göre bir container olusturuyorum.
        Map<String, String> dataMap = new LinkedHashMap<>();
         /*"//tr": This selects all <tr> (table row) elements within the HTML document.

[td[normalize-space(.) = '" + firstName + "'] and td[normalize-space(.) = '" + lastName + "']]:
This part filters the rows based on the condition that either the first name or the last name
matches the specified values (firstName and lastName). Let's break it down further:

td[normalize-space(.) = '" + firstName + "']: This selects a <td> (table cell) element where
the normalized text content of the cell is equal to the provided firstName.

and: This is a logical operator that allows us to combine conditions.

td[normalize-space(.) = '" + lastName + "']: Similarly, this selects a <td> element where
the normalized text content of the cell is equal to the provided lastName.

The result of this part is that it selects rows where the first name and the last name matches
the specified values.

"//td": This selects all <td> (table cell) elements within the selected rows. This is the final step
that retrieves the data from the matched rows.

Putting it all together, the complete XPath locator selects all the <td> elements within the rows where
both the first name and the last name matches the provided values. This is used in your getDataForFullName()
method to extract the data (such as Last Name, First Name, Email, Due, Web Site) from the table cells
that match the specified full name.

For example, if you call getDataForFullName("Frank", "Bach"), the XPath will look for rows where
the first name is "Frank" and the last name is "Bach", and then it will extract all the <td> elements
within those rows to get the corresponding data.*/

        String locator = "//tr[td[normalize-space(.) = '" + firstName + "'] and td[normalize-space(.) = '" + lastName + "']]//td";
        List<WebElement> cells = table1.findElements(By.xpath(locator));

        if (!cells.isEmpty()) {
            String[] headers = {"Last Name", "First Name", "Email", "Due", "Web Site"};
            for (int i = 0; i < headers.length; i++) {
                dataMap.put(headers[i], cells.get(i).getText());
            }
            printDataMap(dataMap);
        } else {
            System.out.println("No data found for " + firstName + " " + lastName + ".");
        }

        return dataMap;
    }

    private void printDataMap(Map<String, String> dataMap){
        if (!dataMap.isEmpty()) {
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public TablesPage() {
        PageFactory.initElements(Driver.get(), this);
    }
}
