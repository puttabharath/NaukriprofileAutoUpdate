package pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileUpdation {
	WebDriver driver;
    WebDriverWait wait;
	public ProfileUpdation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='nI-gNb-drawer__icon']/div[1]")
	 private WebElement threeDots;
	
	@FindBy(xpath = "//a[text()='View & Update Profile']")
	private WebElement viewUpdateProfile;
	
	@FindBy(xpath = "//i[@data-title='delete-resume']")
	private WebElement deleteIcon;
	
	@FindBy(xpath = "(//button[text()='Delete'])[2]")
	private WebElement deletePopupBtn;
	
	@FindBy(xpath = "//span[text()='Upload resume']")
	private WebElement updateResumeBtn;
	
	public void profileUpdateModule() throws Throwable
	{
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement moreOptions = wait.until(ExpectedConditions.elementToBeClickable(threeDots)); 
		moreOptions.click();
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View & Update Profile']")));
element.click();
		deleteIcon.click(); 
        deletePopupBtn.click();
        WebElement updateResume = wait.until(ExpectedConditions.elementToBeClickable(updateResumeBtn));
        updateResume.click();

        
        // Copy file path to clipboard
        StringSelection filePath = new StringSelection("C:\\Users\\bharath\\OneDrive\\Pictures\\Bharath Resumes\\TCS 2.5 years\\Bharath Kumar Putta Resume.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        
        // Use Robot class to paste and press Enter
        Robot robot = new Robot();
        robot.delay(2000); // Wait for file upload dialog
        
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        // Wait for upload
        Thread.sleep(2000);
		
	}

}
