package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DealStepDefinition {

	WebDriver driver;
	
	@Given("^user is already on Login page$")
	public void user_already_on_Login_page() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/");
	}	
	
	@When("^title of Login page is Free CRM$")
	public void title_of_Login_page_is_Free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	
	
	@Then("^user Enters username and password$")
	public void user_Enters_username_and_password(DataTable credentials) {
		List <List<String>> data = credentials.asLists();
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		
	}
	
	
	@Then("^user clicks on Login button$")
	public void user_clicks_on_Login_button() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
	}	
		
	
	@Then("^user is on Home page$")
	public void user_is_on_Home_page() {
		String hometitle = driver.getTitle();
		System.out.println("Home Page Titlt----->" + hometitle);
		Assert.assertEquals("CRMPRO", hometitle);
		
	}
	
	@Then("^user move to new deal page$")
	public void user_move_to_new_deal_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
	}
	
	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable dealData) {
		List <List<String>> dealValues = dealData.asLists();
		driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
		driver.findElement(By.name("amount")).sendKeys(dealValues.get(0).get(1));
		driver.findElement(By.id("probability")).sendKeys(dealValues.get(0).get(2));
		driver.findElement(By.id("commission")).sendKeys(dealValues.get(0).get(3));
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}
	
	@Then("^Close the Browser$")
	public void Close_the_Browser() {
		driver.quit();
	}

}
