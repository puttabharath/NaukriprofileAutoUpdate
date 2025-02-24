package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
    @Test(priority = 1,description = "Verify the functionality of login page")
    public void testLogin() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
    }
}
