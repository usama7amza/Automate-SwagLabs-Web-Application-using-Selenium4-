package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CheckOut {

    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;

    // TODO: define constructor
    public P03_CheckOut(WebDriver driver)
    {
        this.driver=driver;
    }

    // TODO: define locators
    private final By CheckOut_BTN= By.xpath("//a[text()='CHECKOUT']");


    //TODO: define action methods
    // CheckOut Method (1)
    public void checkOut(){
        new CustomDecorator(driver,CheckOut_BTN,1000).click();
    }

}
