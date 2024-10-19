package testcases;

import org.testng.annotations.Test;
import pages.P03_CartPage;

public class TC03_CheckOut extends  TestBase{


    @Test
    public void VerifyCheckOut(){
        new P03_CartPage(driver).checkOut();
    }
}
