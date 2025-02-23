package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class naukritesting {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/nlogin/login?err=1");
		WebElement user = driver.findElement(By.id("usernameField"));
		user.clear();
		user.sendKeys("puttabharathkumar123@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("Bharath@#6981");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']/div[1]")).click();
	}

}
