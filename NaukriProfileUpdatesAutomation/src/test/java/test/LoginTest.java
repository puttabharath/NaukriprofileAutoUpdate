package test;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LoginPage;
import utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends BaseClass{
    @Test
    public void testLogin() throws InterruptedException {

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Fetch credentials from properties file
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        // Perform login
        loginPage.naukriLoginPortal(username, password);
    }
}
