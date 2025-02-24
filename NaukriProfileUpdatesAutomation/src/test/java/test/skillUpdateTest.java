package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import pages.skillsUpdate;

public class skillUpdateTest extends BaseClass{
	
	@Test(priority = 3,description = "Verify the functionality by removing and adding the any skill in the Skills Section")
	public void skillUpdationTest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
		skillsUpdate skill = new skillsUpdate(driver);
				skill.addDeleteSkills();
	}

}
