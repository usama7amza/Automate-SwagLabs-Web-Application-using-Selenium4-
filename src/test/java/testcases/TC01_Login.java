package testcases;

import common.MyScreenRecorder;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.PageBase;

public class TC01_Login extends TestBase {

    String username = "standard_user";
    String password = "secret_sauce";
    String CurrentURL = "https://www.saucedemo.com/v1/inventory.html";

    @Test(priority = 1, description = "Login with valid username and password")
    public void loginWithValidUsernameAndPassword() throws Exception {
        new P01_LoginPage(driver).enterUserName(username).enterPassword(password).clickLoginButton();


        //Take screenshot
        PageBase.captureScreenshot(driver, "Login screenShot");

        // assertion
        Assert.assertEquals(new P01_LoginPage(driver).GetCurrentURL(), CurrentURL);
    }
}
