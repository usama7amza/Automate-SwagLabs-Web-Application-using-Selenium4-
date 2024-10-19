package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P03_CartPage;

public class TC03_Cart extends  TestBase{
String InfoPageURL = "https://www.saucedemo.com/v1/checkout-step-one.html";

    @Test
    public void VerifyCheckOut(){
        new P03_CartPage(driver).checkOut();
        Assert.assertEquals(new P03_CartPage(driver).GetInfoPagURL(),InfoPageURL);
    }
}
