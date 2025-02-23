package test;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;
import pages.ProfileUpdation;

public class ProfileUpdationTest extends BaseClass{
	
	@Test
	public void profileUpdate() throws Throwable
	{
	    LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
		ProfileUpdation profileupdate = new	ProfileUpdation(driver);
		profileupdate.profileUpdateModule();
	}

}
