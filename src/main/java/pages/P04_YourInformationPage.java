package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_YourInformationPage {


    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;
    // TODO: define constructor
    public P04_YourInformationPage(WebDriver driver)
    {

        this.driver=driver;
    }

    // TODO: define locators
    private final By FirstName_Text= By.id("first-name");
    private final By Lastname_Text= By.id("last-name");
    private final By ZipCode_Text= By.id("postal-code");
    private final By Continue_BTN= By.xpath("//input [@type='submit']");
;

    //TODO: define action methods
    // Enter FirstName Method (1)
    public P04_YourInformationPage EnterFirstName(String firstName){
        new CustomDecorator(driver,FirstName_Text,1000).sendKeys(firstName);
        return this;
    }


    //TODO: define action methods
    // Enter LastName Method (2)
    public P04_YourInformationPage EnterLastName(String lastName){
        new CustomDecorator(driver,Lastname_Text,1000).sendKeys(lastName);
        return this;
    }

    //TODO: define action methods
    // Enter ZipCode Method (3)
    public P04_YourInformationPage EnterZipCode(String zipCode){
        new CustomDecorator(driver,ZipCode_Text,1000).sendKeys(zipCode);
        return this;
    }

    //TODO: define action methods
    // Enter Click on Continue button  Method (4)
    public P04_YourInformationPage ClickOnContinueButton(){
        new CustomDecorator(driver,Continue_BTN,1000).click();
        return this;

    }
    public String GetOverviewPagURL()
    {
        return driver.getCurrentUrl();
    }


}

