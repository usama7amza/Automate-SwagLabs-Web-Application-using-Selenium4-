package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P02_ProductPage;
import pages.P03_CartPage;
import pages.P05_OverviewPage;
import util.Utility;

import java.util.List;
public class TC05_Overview extends TestBase {

String SuccessMessage = "THANK YOU FOR YOUR ORDER";

    @Test (priority = 1)
    public void VerifyItemsPrice(){
        P03_CartPage cartPage = new P03_CartPage(driver);
        // Get total price from cart
        double totalPriceFromCart = cartPage.getTotalPriceListFromCart();
        // Get total price from the overview page
        double totalPriceFromOverview = new P05_OverviewPage(driver).GetTotalPrice();
        // Assert that the two prices are equal
        System.out.println("Total Price from Cart: " + totalPriceFromCart);
        System.out.println("Total Price from Overview: " + totalPriceFromOverview);



        Assert.assertEquals(totalPriceFromOverview, totalPriceFromCart);
    }


    @Test(priority = 2)
    public void VerifyFinishProcessSuccess(){
        new P05_OverviewPage(driver).ClickOnFinishButton();
        // Click on the Finish button

        // Get the success message
        String actualSuccessMessage = new P05_OverviewPage(driver).GetSuccessText();

        // Assert that the success message matches the expected message
        Assert.assertEquals(actualSuccessMessage, SuccessMessage);
    }
    }




