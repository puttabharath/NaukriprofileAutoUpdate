package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.ResumeHeadlineModule;

public class ResumeHeadlineTest extends BaseClass {
	@Test(priority = 4,description = "Verify the functionality by removing and adding the resume headline text")
	public void resumeHeadlineTest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
		ResumeHeadlineModule rhm= new ResumeHeadlineModule(driver);
		rhm.resumeHeadline();
	}

}
