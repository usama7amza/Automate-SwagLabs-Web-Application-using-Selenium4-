package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_LoginPage;

public class TC01_Login extends TestBase{

    String username="standard_user";
    String password="secret_sauce";

    @Test(priority = 1, description = "Login with valid username and password")
    public void loginWithValidUsernameAndPassword(){
        new P01_LoginPage(driver).enterUserName(username).enterPassword(password).clickLoginButton();
        // assertion
//        Assert.assertEquals(new P01_LoginPage(driver).getHeaderTest(),"swaglabs");
    }
}
