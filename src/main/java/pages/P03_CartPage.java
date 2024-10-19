package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P03_CartPage {

    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;

    // TODO: define constructor
    public P03_CartPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // TODO: define locators
    private final By itemsPriceList = By.xpath("//div[@class=\"inventory_item_price\"]");

    private final By CheckOut_BTN= By.xpath("//a[text()='CHECKOUT']");



    //TODO: define action methods
    // getTotalPriceList Method (1)
    public double getTotalPriceListFromCart() {
        double totalProductPrices = 0.0;

        // Wait for all price elements to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> priceList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemsPriceList));

        for (WebElement priceElement : priceList) {
            // Convert price text to double (removing the $ symbol if needed)
            String priceText = priceElement.getText().replace("$", "").trim();

            // Check if the price text is not empty
            if (!priceText.isEmpty()) {
                double productPrice = Double.parseDouble(priceText); // Get price for each product
                totalProductPrices += productPrice; // Sum the prices
            } else {
                System.out.println("Price element is empty or not found");
            }
        }

        System.out.println("Total Price in cart page = " + totalProductPrices);
        return totalProductPrices;
    }

    //TODO: define action methods
    // CheckOut Method (2)
    public void checkOut(){
        new CustomDecorator(driver,CheckOut_BTN,1000).click();
    }



    public String GetInfoPagURL()
    {
        return driver.getCurrentUrl();
    }

}
