package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage {
<<<<<<< HEAD
    WebDriver driver;   
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
  String username=  ConfigReader.getProperty("username");
	String password= ConfigReader.getProperty("password");
    
    @FindBy( id = "usernameField")   // Update with actual ID or locator
    WebElement usernameField;
=======
    public WebDriver driver;
    public WebDriverWait wait;
>>>>>>> master

    // Locators
    @FindBy(xpath = "//input[@id='usernameField']")
    private WebElement usernameField;

    @FindBy(id = "passwordField")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;
    
    @FindBy(xpath = "//div[@class='nI-gNb-drawer__icon']/div[1]")
	 private WebElement threeDots;
	
	@FindBy(xpath = "//a[text()='View & Update Profile']")
	private WebElement viewUpdateProfile;

<<<<<<< HEAD
    // Method to perform login
    public void naukriLoginPortal() throws InterruptedException {


	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement username1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("usernameField")));
	    
        username1.clear();
        username1.sendKeys(username);
=======
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
>>>>>>> master

    // Method to handle login
    public void naukriLoginPortal(String username, String password) throws InterruptedException {
    
        // Wait until username field is visible
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);

        // Click login button
        
<<<<<<< HEAD
        driver.switchTo().defaultContent(); // Switch back to main content
        Thread.sleep(3000);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals("https://www.naukri.com/mnjuser/homepage", driver.getCurrentUrl());
        sa.assertAll();
        
		WebElement moreOptions = wait.until(ExpectedConditions.elementToBeClickable(threeDots)); 
=======
       wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
       
       WebElement moreOptions = wait.until(ExpectedConditions.elementToBeClickable(threeDots)); 
>>>>>>> master
		moreOptions.click();
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View & Update Profile']")));
element.click();
        
    }
}
