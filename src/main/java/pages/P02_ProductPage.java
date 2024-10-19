package pages;

import actions.CustomDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class P02_ProductPage {

    // 1- constructor
    // 2- locators
    // 3- public action methods

    // TODO: define web driver
    WebDriver driver;

    // TODO: define constructor
    public P02_ProductPage(WebDriver driver)
    {
        this.driver=driver;
    }

    // TODO: define locators
    private final By ProductItem_List = By.xpath("//div[@class ='inventory_item']");
    private final By ItemsPrice_Text = By.xpath("//div[@class ='inventory_item_price']");
    private final By ItemsAddToCart_BTN = By.xpath("//button[text()='ADD TO CART']");
    private final By Cart_BTN = By.xpath("//a[@href='./cart.html']");
    private final By Remove_BTN = By.xpath("//button[text()='REMOVE']");

    //TODO: define action methods
    // Method to add a product to the cart based on the product number (1)
    // Method to add products to the cart based on a list of product numbers

    public void addRandomProductsToCart(List<Integer> productNumbers) {
        for (int productNumber : productNumbers) {
            // Using the product number to build the XPath dynamically
            String ProductsItem_List = "//div[@class='inventory_item'][" + productNumber + "]//button[text()='ADD TO CART']";
            driver.findElement(By.xpath(ProductsItem_List)).click();
        }
    }

    //TODO: define action methods
    // Method to add a product to the cart based on the product number (1)
    // Method to add products to the cart based on a list of product numbers

    public boolean IsRemoveTextIsDisplayed() {
        driver.findElement(Remove_BTN).isDisplayed();

        return true;
    }





    //TODO:
    // Method to get the total price of products based on their product numbers(2)

    // Method to get the total price of products based on their product numbers
    public double getTotalPrice(List<Integer> productNumbers) {
        double totalProductPrices = 0.0;

        // Create an instance of WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int productNumber : productNumbers) {
            // Build XPath to get the price of the selected product
            String ProductsPrice_List = "//div[@class='inventory_item'][" + productNumber + "]//div[@class='inventory_item_price']";

            // Wait until the price element is visible and then find it
            WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ProductsPrice_List)));

            // Convert price text to double (removing the $ symbol if needed)
            String priceText = priceElement.getText().replace("$", "");
            double productPrice = Double.parseDouble(priceText); // Get price for each product
            totalProductPrices += productPrice; // Sum the prices
        }

        return totalProductPrices;

}

   //TODO:
   // Method openCartPage (3)
    public void openCartPage(){
        new CustomDecorator(driver,Cart_BTN,1000).click();
    }



    public String GetCartPagURL()
    {
        return driver.getCurrentUrl();
    }

}
