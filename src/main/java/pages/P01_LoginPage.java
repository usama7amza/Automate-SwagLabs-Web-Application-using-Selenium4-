package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage {

    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;

    // TODO: define constructor
    public P01_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // TODO: define locators
    private final By USERNAME_TEXT= By.xpath("//input[@data-test=\"username\"]");
    private final By PASSWORD_TEXT= By.xpath("//input[@data-test=\"password\"]");
    private final By LOGIN_BUTTON= By.id("login-button");


    public P01_LoginPage enterUserName(String username){

        new CustomDecorator(driver,USERNAME_TEXT,0).sendKeys(username);
        return this;
    }
    public P01_LoginPage enterPassword(String password){
        new CustomDecorator(driver,PASSWORD_TEXT,1000).sendKeys(password);

        return this;
    }
    public P01_LoginPage clickLoginButton(){
        new CustomDecorator(driver,LOGIN_BUTTON,4000).click();

        return this;
    }
    public String GetCurrentURL()
    {
        return driver.getCurrentUrl();
    }

}
