package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utils.ConfigReader;

public class LoginPage {
    WebDriver driver;   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  String username=  ConfigReader.getProperty("username");
	String password= ConfigReader.getProperty("password");
    
    @FindBy(xpath = "//input[@id='usernameField']")   // Update with actual ID or locator
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='passwordField']")   // Update with actual ID or locator
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")  // Update with actual locator
    WebElement loginButton;

    // Method to perform login
    public void naukriLoginPortal() throws InterruptedException {
        usernameField.clear();
        usernameField.sendKeys(username);

        passwordField.sendKeys(password);
        loginButton.click();
        
        driver.switchTo().defaultContent(); // Switch back to main content
        Thread.sleep(3000);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals("https://www.naukri.com/mnjuser/homepage", driver.getCurrentUrl());
        sa.assertAll();
    }
}
