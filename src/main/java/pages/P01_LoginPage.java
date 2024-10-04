package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_LoginPage {

    // 1- constructor
    // 2- locators
    // 3- public action methods

    // @FinfBy == driver.findElemnt(By.xpath(""))

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
        driver.findElement(this.USERNAME_TEXT).sendKeys(username);
        return this;
    }
    public P01_LoginPage enterPassword(String password){
        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }
    public P01_LoginPage clickLoginButton(){
        driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }

    public String getHeaderTest(){
        return driver.findElement(By.xpath("")).getText();
    }

//    // TODO: define public action methods
//    public void login(String username, String password){
//        driver.findElement(this.USERNAME_TEXT).sendKeys(username);
//        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
//        driver.findElement(this.LOGIN_BUTTON).click();
//    }



}
