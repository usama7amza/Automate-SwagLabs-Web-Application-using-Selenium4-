package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P04_YourInformationPage;
import util.Utility;

public class TC04_YourInformation extends TestBase {

String OverViewPagURL= "https://www.saucedemo.com/v1/checkout-step-two.html";
    @Test
    public void VerifyFillInfo(){
       new P04_YourInformationPage(driver).EnterFirstName(Utility.getFirstName()).
               EnterLastName(Utility.getLastName()).EnterZipCode(Utility.getZipCode()).ClickOnContinueButton();


        Assert.assertEquals(new P04_YourInformationPage(driver).GetOverviewPagURL(),OverViewPagURL);
    }
}
