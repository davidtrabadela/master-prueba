package com.seleniumsimplified.junit;

import org.openqa.selenium.Alert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrearIniciativa 
{
	final String DOMAIN = "fundacionpreprod.accenture.com";
	final String HTTP = "https://";
	final String WWW = "www.";
	final String usrUsr = "qauser@accenture.com";
	final String pwdUsr = "qauser01";
	final String url = "";
	WebElement button;

	@Test
	public void loginTest () throws InterruptedException 
	{ 
		System.setProperty("webdriver.chrome.driver", "C:/ChromeDriver/ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		System.out.println("Heading to Login URL: " + HTTP + DOMAIN);
		driver.navigate().to(HTTP + DOMAIN);
		
		System.out.println("Maximizing Window");
		driver.manage().window().maximize();
		
		//LOGIN
	    WebElement usr = driver.findElement(By.id("_58_login"));
		WebElement pwd = driver.findElement(By.id("_58_password"));
		//Enter user
		usr.sendKeys(Keys.CONTROL + "a");
		usr.sendKeys(Keys.DELETE);
		usr.sendKeys(usrUsr);
		System.out.println("User: " + usr + " -> " + usrUsr);
	    //Enter password
		pwd.sendKeys(pwdUsr);
		System.out.println("Password: " + pwd + " -> " + pwdUsr);
		pwd.sendKeys(Keys.ENTER);
		System.out.println("Login successful");
	
		
	    //Handling the JS error alert.
		Alert confirmationAlert = driver.switchTo().alert();
		System.out.println("Waiting for alert @ index");
		System.out.println("Alert dismissed");
		confirmationAlert.dismiss();
		System.out.println("Waiting for index to load");
			
		driver.findElement(By.className("nueva-iniciativa-btn")).click();
		System.out.println("Heading to 'Crear nueva iniciativa': " + HTTP + DOMAIN + "/group/guest/crear-iniciativa");
				
		//Find buttons from the Dropdown	
		List<WebElement> buttonList = driver.findElements(By.xpath("//div[@class='v-filterselect-button']"));
				
		/*
		Option and Button manipulation and navigation for both DropDowns
		This can be used for ANY DropDowns in FACC since they all behave the same. 
		The only thing that has to be manually edited is the driver.findElements to point to the right element.
		*/
		for (int i = 0; i < buttonList.size(); i++) //Button process
		{
			
			WebElement buttonDD = buttonList.get(i);
			buttonDD.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                                   
			List<WebElement> optionsListB = driver.findElements(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr"));
			//Auxiliary variable optionsListB is created to have dynamic size for each DropDown.
			
			for (int e = 0; e < optionsListB.size(); e++) //Options process
			{	
				List<WebElement> optionsList = driver.findElements(By.xpath("//*[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr"));
				WebElement optionsDD = optionsList.get(e);
				String optionText = optionsList.get(e).getText();
				System.out.println("Selected option: " + optionsList.get(e) + " -> "+ optionText);
				
				optionsDD.click();
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
				//Create an auxiliary variable and 'if' fix exit of Options iteration process. 
				//If removed, DropDown will remain open and button process will FAIL.
				int d = e+1;
				if (d < optionsListB.size()) {
					buttonDD.click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
			}
		}
		
		WebElement iniName = driver.findElement(By.id("gwt-uid-5"));
		iniName.sendKeys("MLG/DPCS - Automated New Initiative - A.Pane");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		button = driver.findElement(By.className("v-button-btn-primary"));
		button.click();
		
		//driver.close();
		//driver.quit();
		
	}

		
}
