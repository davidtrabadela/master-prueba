package NEWPROJECTCUCUMBER.NEWPROJECTCUCUMBER;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class PruebaCucumberTest {
	
	private WebDriver driver=null;
	
	
	
	@Given("^user opens login page$")
	public void  user_opens_login_page (){
		driver=new FirefoxDriver();
		driver.get("https://login.yahoo.com");	
	}
	@Then("^user enters userid$")
	public void user_enters_userid(){
		driver.findElement(By.xpath("//*[@id='login-username']")).sendKeys("test@yahoo.com");
	}
	@Then("^user enters password$")
	public void user_enters_password(){
		driver.findElement(By.xpath("//*[@id='login-passwd']")).sendKeys("test123");
	}
	
	@Then("^get the title of yahoo login page and verify$")
	public void verify_yahoo_login_Page_Title(){
		String title=driver.getTitle();
		Assert.assertEquals("Yahoo - login", title);
	}
	
	@And("^user clicks on signin button$")
	public void user_clicks_on_signin_button(){
		driver.findElement(By.xpath("//*[@id='login-signin']")).click();;
	}
	@And("^close the browser$")
	public void close_the_browser(){
		driver.quit();
		//BUSCANDO CAMBIOS EN GIT
	}
	
	
	

}
