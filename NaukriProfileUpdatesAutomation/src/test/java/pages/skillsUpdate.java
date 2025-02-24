package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class skillsUpdate {
    WebDriver driver;
    public skillsUpdate(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='widgetHead typ-16Bold']/span[1]")
    private WebElement keySkillsElement;
    
    @FindBy(xpath = "//div[@class='widgetHead typ-16Bold']/span[text()='editOneTheme']")
    private WebElement editIconKeySkills;

    @FindBy(id = "keySkillSugg")
    private WebElement keySkillsInputfld;
    
    @FindBy(xpath = "//li[@class='sugTouple']")
    private List<WebElement> suggestedSkills;

    @FindBy(id = "saveKeySkills")
    private WebElement saveBtn;
    
    
    public void addDeleteSkills() throws InterruptedException {
    	Point loc = keySkillsElement.getLocation();
    	System.out.println(loc);
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
    	jse.executeScript("window.scrollBy(520,400) "); //scroll till the key skills
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(editIconKeySkills)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(keySkillsInputfld)).clear();
    	wait.until(ExpectedConditions.elementToBeClickable(keySkillsInputfld)).sendKeys("SQL");

       Thread.sleep(3000);
       for(int i=0;i<suggestedSkills.size();i++)
       {
    	  WebElement suggestedSkill = suggestedSkills.get(i);
    	  String skillName = suggestedSkill.getText();
    	  if (skillName.equals("SQL"))
    	  {
    		  suggestedSkill.click();
    		  break;
    	  }
    	 
       }
       
       saveBtn.click();
       
       


    }
}
