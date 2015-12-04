package NEWPROJECTCUCUMBER.NEWPROJECTCUCUMBER;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static junit.framework.Assert.assertTrue;

public class AlejoPrueba 
{
	@Test
	public void driverTest () throws InterruptedException 
	{
		WebDriver driverChrome = new FirefoxDriver();
		driverChrome.navigate().to("https://fundacionpreprod.accenture.com/");
		driverChrome.findElement(By.id("_58_login")).sendKeys("admin@liferay.com");
		driverChrome.findElement(By.id("_58_password")).sendKeys("Accenture01");
		driverChrome.findElement(By.className("btn-primary")).click();
	    driverChrome.findElement(By.cssSelector(".footer > .link"));
	   
		//driverChrome.manage().timeouts().wait(500);
	    	    
	    assertTrue(true);
	}
}
