package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.ProfileUpdation;


public class ProfileUpdationTest extends BaseClass{
	
	@Test(priority = 2,description = "Verify the functionality by adding and removing the resume file in Profile section")
	public void profileUpdate() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
		ProfileUpdation profileupdate = new	ProfileUpdation(driver);
		profileupdate.profileUpdateModule();
	}
}
