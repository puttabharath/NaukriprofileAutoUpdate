package test;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	
    @Test
    public void testLogin() throws InterruptedException {
    	//String username= prop.getProperty("username");
    	//String password= prop.getProperty("password");
//    	  if (username == null || password == null) {
//              throw new RuntimeException("Username or password is missing in the properties file!");
//          }
    	
        LoginPage lp = new LoginPage(driver);
        lp.naukriLoginPortal(); 
    }
}
