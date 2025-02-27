package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    
    @FindBy( id = "usernameField")   // Update with actual ID or locator
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='passwordField']")   // Update with actual ID or locator
    WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")  // Update with actual locator
    WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='nI-gNb-drawer__icon']/div[1]")
	 private WebElement threeDots;
	
	@FindBy(xpath = "//a[text()='View & Update Profile']")
	private WebElement viewUpdateProfile;

    // Method to perform login
    public void naukriLoginPortal() throws InterruptedException {


	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement username1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameField")));
	    
        username1.clear();
        username1.sendKeys(username);

        passwordField.sendKeys(password);
        loginButton.click();
        
        driver.switchTo().defaultContent(); // Switch back to main content
        Thread.sleep(3000);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals("https://www.naukri.com/mnjuser/homepage", driver.getCurrentUrl());
        sa.assertAll();
        
		WebElement moreOptions = wait.until(ExpectedConditions.elementToBeClickable(threeDots)); 
		moreOptions.click();
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View & Update Profile']")));
element.click();
    }
}
