package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinition {
	
	
	WebDriver driver;
	
	
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/");
		
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //page loading time
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //element find out time
	}
	
	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	
	//Reg Exp:
	//1. \"([^\"]\"
	//2. \"(.*)\"
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
		driver.findElement(By.name("username")).sendKeys("Ravikumar@9999");
		driver.findElement(By.name("password")).sendKeys("test@9999");
		
	}
	
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
		
		//JavascriptExecutor for click on login button
//		WebElement loginBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input"));
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("aruguments[0].click();", loginBtn);
		
	}
	
	
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String hometitle = driver.getTitle();
		System.out.println("Home Page Titlt----->" + hometitle);
		//Assert.assertEquals("CRMPRO", hometitle);
		
	}
	
	@Then("^user move to new contact page$")
	public void user_move_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}
	
	
	@Then("^user enters contacts details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_contacts_details(String firstname, String lastname, String position) {
		driver.findElement(By.id("first_name")).sendKeys(firstname);
		driver.findElement(By.id("surname")).sendKeys(lastname);
		driver.findElement(By.id("company_position")).sendKeys(position);
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}
	
	@Then("^Close the browser$")
	public void Close_the_browser() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	

}
