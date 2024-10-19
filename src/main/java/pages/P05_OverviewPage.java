package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P05_OverviewPage {


    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;
    // TODO: define constructor
    public P05_OverviewPage(WebDriver driver)
    {

        this.driver=driver;
    }

    // TODO: define locators
    private final By ItemTotalPrice_Text= By.xpath("//div[@class='summary_subtotal_label']");
    private final By ItemTax_Text= By.xpath("//div[@class='summary_tax_label']");
    private final By ItemTotalWithTak= By.xpath("//div[@class='summary_total_label']");
    private final By Finish_BTN= By.xpath("//a[text()='FINISH']");
    private final By SuccessMessage_Text= By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");

    //TODO: define action methods
    // Get Total Price (1)
    public double GetTotalPrice() {
        // Add WebDriverWait to ensure the element is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement totalPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(ItemTotalPrice_Text));

        // Get text after ensuring visibility
        String totalPriceText = totalPriceElement.getText().replace("Item total: $", "").trim(); // Make sure the text matches your app's structure

        if (!totalPriceText.isEmpty()) {
            return Double.parseDouble(totalPriceText);
        } else {
            System.out.println("Total price element is empty or not found");
            return 0.0; // Default value in case of error
        }
    }

    //TODO: define action methods
    // Get  tax (2)
    public P05_OverviewPage GetTax( ){
        new CustomDecorator(driver,ItemTax_Text,1000).getText();
        return this;
    }

    //TODO: define action methods
    // Get Total Price (3)
    public P05_OverviewPage GetTotalPriceWithTax( ){
        new CustomDecorator(driver,ItemTotalWithTak,1000).getText();
        return this;
    }



    //TODO: define action methods
    // Click On Finish BTN (5)
    public P05_OverviewPage ClickOnFinishButton( ){
        new CustomDecorator(driver,Finish_BTN,1000).click();
        return this;
    }



    //TODO: define action methods
    // Click On GetSuccessText(5)
    public String GetSuccessText() {
        return driver.findElement(SuccessMessage_Text).getText();
    }
}
