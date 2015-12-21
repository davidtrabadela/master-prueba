package com.seleniumsimplified.junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class AlejoPrueba 
{
	
	final String DOMAIN = "fundacionpreprod.accenture.com";
	final String HTTP = "https://";
	final String WWW = "www.";
	final String usrAdm = "admin@liferay.com";
	final String pwAdm = "Accenture01";
	
	
	@Test
	public void driverTest () throws InterruptedException 
	{
		WebDriver driver = new HtmlUnitDriver();
		
		//Access site and login - START
		driver.get(HTTP + DOMAIN);
		
		//Enter user
		WebElement user = driver.findElement(By.id("_58_login"));
		user.sendKeys(Keys.CONTROL + "a");
		user.sendKeys(Keys.DELETE);
		user.sendKeys(usrAdm);
		
		//Enter password
		WebElement pwd = driver.findElement(By.id("_58_password"));
		pwd.sendKeys(pwAdm);
		
		//Click Login button
		driver.findElement(By.className("btn-primary")).click();
		
		//assertEquals("Login successful, continuing test", HTTP + DOMAIN + "/group/guest/inicio", driverChrome.getCurrentUrl());		
		//Access site and login - END
		
		

//assertThat(driverChrome.getCurrentUrl(), is(HTTP + DOMAIN + "/group/guest/crear-iniciativa"));

		
		//Create new initiative - START
		driver.findElement(By.cssSelector("yui_patched_v3_11_0_1_1450255790923_340")).click();
		assertEquals("URL is correct, continuing test", HTTP + DOMAIN + "/group/guest/crear-iniciativa", driver.getCurrentUrl());
		
		driver.findElement(By.cssSelector("input.gwt-uid-3")).sendKeys("Cooperación al desarrollo");
		driver.findElement(By.id("gwt-uid-7")).sendKeys("Iniciativa Económica");
		driver.findElement(By.id("gwt-uid-5")).sendKeys("MLG-DPCS Automated first try");
		driver.findElement(By.className("v-button-btn-primary")).click();
		
	
		
	}
	
	
}
