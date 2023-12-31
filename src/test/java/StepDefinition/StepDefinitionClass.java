package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.messages.internal.com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionClass extends BaseClass{
	String lookupNewEmail;
	
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// allocating memory to Loginpage
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println();
	}

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		

		lp = new LoginPage(driver);

		// allocating memory to AddNewCustomerPage
		ancp = new AddNewCustomerPage(driver);
		scbe = new SearchCustomerByEmail(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String passwordAdd) {

		lp.enterEmail(emailAdd);
		lp.enterPassword(passwordAdd);
	}

	@When("click on Login")
	public void click_on_login() {

		lp.clickLogin();
	}
////////LoginFeature//////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);// Pass
		} else {
			Assert.assertTrue(false);// fail
		}

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {

		lp.clickLogout();
	}

	 @Then("close browser")
	 public void close_browser() {

	 driver.close();
	 driver.quit();
	 }

////Add new customer steps//
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		//This is the verification/checkpoint, verify the NEW page title
		String actualTitle = ancp.GetPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
		ancp.ClickOnCustomerMenu();
		
		
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		ancp.ClickOnMenuItem();
		
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		ancp.ClickOnAddNew();
		
	}

	@Then("User can view and Add new customer page")
	public void user_can_view_and_add_new_customer_page() {
		//This is the verification/checkpoint, verify the NEW page title
		
		String ExpectedTitle = "Add a new customer / nopCommerce administration";
		String ActualTitle = ancp.GetPageTitle();
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		//lookupNewEmail = ancp.EnterEmail()+ "@gmail.com";
		//ancp.EnterEmail(lookupNewEmail);
		Thread.sleep(1000);
		ancp.EnterEmail("tqman12541@gmail.com");
		Thread.sleep(1000);
		ancp.EnterPassword("Test123");
		Thread.sleep(1000);
		ancp.EnterFirstName("Doctor");
		Thread.sleep(1000);
		ancp.EnterLastName("Who");
		Thread.sleep(1000);
		ancp.EnterDOB("02/01/1999");
		Thread.sleep(1000);
		ancp.CompanyName("PnT");
		Thread.sleep(1000);
		ancp.EnterGender("Male");
		
	}

	@When("click on Save button")
	public void click_on_save_button() {
		ancp.SaveButton();
		
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String ExpectedConfirmMessage) {
		String text = driver.findElement(By.tagName("Body")).getText();
		
		if(text.contains(ExpectedConfirmMessage)) 
		{
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}

	//@Then("close browser")
	//public void close_browser() {
		
		
	//}
	/////Search customer by email///////
	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		scbe.EnterEmail("tqm1@gmail.com");
		/*if(lookupNewEmail != null) {
		    scbe.EnterEmail(lookupNewEmail);

		}else {
			System.out.println("lookupNewEmail is null");
		}*/
	    Thread.sleep(1000);
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
	    scbe.ClickOnSearchButton();
	    Thread.sleep(1000);
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
	    String ExpectedEmail = "CVAUM@gmail.com";
	    Assert.assertTrue(scbe.SearchCustomerByEmail(ExpectedEmail));
	    
	}
	@After
	public void teardown(Scenario sc) throws IOException {
		if(sc.isFailed() == true) {
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(f, new File("C:\\Users\\tm\\eclipse-workspace\\CucumberFramework\\Screenshot\\failedscreenshot.png"));
		}
		System.out.println("teardown executed");
		
		driver.quit();
	}




}
