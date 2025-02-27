package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.ProfileUpdation;
import utils.ConfigReader;


public class ProfileUpdationTest extends BaseClass{
	
	@Test(priority = 2,description = "Verify the functionality by adding and removing the resume file in Profile section")
	public void profileUpdate() throws Throwable
	{
        LoginPage loginPage = new LoginPage(driver);

        // Fetch credentials from properties file
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Perform login
        loginPage.naukriLoginPortal(username, password);
        
		ProfileUpdation profileupdate = new	ProfileUpdation(driver);
		profileupdate.profileUpdateModule();
	}
}
