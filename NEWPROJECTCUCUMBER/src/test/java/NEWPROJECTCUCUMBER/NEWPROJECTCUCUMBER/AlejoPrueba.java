package NEWPROJECTCUCUMBER.NEWPROJECTCUCUMBER;

import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.firefox.FirefoxDriver;




import static junit.framework.Assert.assertTrue;

public class AlejoPrueba 
{
	@Test
	public void driverTest () throws InterruptedException 
	{
		WebDriver driverChrome = new FirefoxDriver();
		
		//Access site and login - start
		driverChrome.navigate().to("https://fundacionpreprod.accenture.com/");
		driverChrome.manage().window().maximize();
		driverChrome.findElement(By.id("_58_login")).sendKeys(Keys.CONTROL + "a");
		driverChrome.findElement(By.id("_58_login")).sendKeys(Keys.DELETE);
		driverChrome.findElement(By.id("_58_login")).sendKeys("admin@liferay.com");
		driverChrome.findElement(By.id("_58_password")).sendKeys("Accenture01");
		driverChrome.findElement(By.className("btn-primary")).click();
		//Access site and login - end
		
		//Create new initiative - start
		driverChrome.findElement(By.className("nueva-iniciativa-btn")).click();

		driverChrome.findElement(By.cssSelector("input.gwt-uid-3")).sendKeys("Cooperación al desarrollo");
		driverChrome.findElement(By.id("gwt-uid-7")).sendKeys("Iniciativa Económica");
		driverChrome.findElement(By.id("gwt-uid-5")).sendKeys("MLG-DPCS Automated first try");
		driverChrome.findElement(By.className("v-button-btn-primary")).click();
		
		assertTrue(true);
	}
}
