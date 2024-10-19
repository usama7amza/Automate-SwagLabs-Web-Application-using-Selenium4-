package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_ProductPage;
import util.Utility;

import java.util.List;

import static testcases.TestBase.driver;

public class TC02_Product extends TestBase {

    P02_ProductPage productPage;
    String GetCartURL = "https://www.saucedemo.com/v1/cart.html";

    @Test
    public void VerifyAddRandomProductsToCart() {
        // Get random product numbers from Util
        List<Integer> randomProductNumbers = Utility.getRandomProductNumbers();
        // Add random products to the cart
        new P02_ProductPage(driver).addRandomProductsToCart(randomProductNumbers);
        // Calculate the total price of the added products
        double totalPrice = new P02_ProductPage(driver).getTotalPrice(randomProductNumbers);
        // Print the total price for debugging
        System.out.println("Total price of selected products: $" + totalPrice);

        // For debugging, print the random products added
        System.out.println("Random products added to cart: " + randomProductNumbers);
        new P02_ProductPage(driver).IsRemoveTextIsDisplayed();
        Assert.assertTrue( new P02_ProductPage(driver).IsRemoveTextIsDisplayed());


    }



    @Test
    public void VerifyOpenCartPage(){
        new P02_ProductPage(driver).openCartPage();
        Assert.assertEquals(new P02_ProductPage(driver).GetCartPagURL(),GetCartURL);
    }
}
