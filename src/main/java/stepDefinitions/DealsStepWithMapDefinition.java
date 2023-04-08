package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//data table with maps : for parameterization of test cases
public class DealsStepWithMapDefinition {

	WebDriver driver;
	
	@Given("^iuser is already on Login Page$")
	public void iuser_is_already_on_Login_Page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/");
	}	
	
	@When("^title of login page is Free Crm$")
	public void title_of_login_page_is_Free_Crm() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	
	
	@Then("^iuser enters username and password$")
	public void iuser_enters_username_and_password(DataTable credentials) {
		for(Map<String, String> data : credentials.asMaps(String.class, String.class)) {
		
		driver.findElement(By.name("username")).sendKeys(data.get("userName"));
		driver.findElement(By.name("password")).sendKeys(data.get("Password"));
		
	}
	}	
	
	@Then("^iuser clicks on login button$")
	public void iuser_clicks_on_login_button() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
	}	
		
	
	@Then("^iuser is on home page$")
	public void iuser_is_on_home_page() {
		String hometitle = driver.getTitle();
		System.out.println("Home Page Titlt----->" + hometitle);
		Assert.assertEquals("CRMPRO", hometitle);
		
	}
	
	@Then("^iuser move to new deal page$")
	public void iuser_move_to_new_deal_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
	}
	
	@Then("^iuser enters deal details$")
	public void iuser_enters_deal_details(DataTable dealData) {
		for(Map<String, String> data : dealData.asMaps(String.class, String.class)) {
			
			driver.findElement(By.id("title")).sendKeys(data.get("title"));
			driver.findElement(By.id("amount")).sendKeys(data.get("amount"));
			driver.findElement(By.id("probability")).sendKeys(data.get("probability"));
			driver.findElement(By.id("commission")).sendKeys(data.get("commission"));
			driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
			
			//move to new deal page
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
			
		}
		
	}
	
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}
	

}
