package PageObject;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {

	WebDriver ldriver;
//Create constructor
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver, this);
		
	}
	//Finding all the elements on the webpage
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement linkCustomer_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement linkCustomer_menuItems;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addNewBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement emailBtn;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement passbtn;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement maleBtn;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement femaleBtn;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement dobBtn;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement companyBtn;
	
	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']")
	WebElement CRolebtn;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement saveBtn;
	
//Action methods for the above Web elements
	
	public String GetPageTitle() 
	{
		return ldriver.getTitle();
		
	}
	public void ClickOnCustomerMenu() 
	{
		linkCustomer_menu.click();
	}
	
	public void ClickOnMenuItem() 
	{
		linkCustomer_menuItems.click();
	}
	public void ClickOnAddNew() 
	{
		addNewBtn.click();
	}
	public void EnterEmail(String email) 
	{
		emailBtn.sendKeys(email);
	}
	public void EnterPassword(String password) 
	{
		passbtn.sendKeys(password);
	}
	public void EnterFirstName(String fname) 
	{
		firstname.sendKeys(fname);
	}
	public void EnterLastName(String lname) 
	{
		lastname.sendKeys(lname);
	}
	public void EnterDOB(String dob) 
	{
		dobBtn.sendKeys(dob);
	}
	public void EnterGender(String gender) 
	{
		if (gender.equals("Male")) {
			maleBtn.click();
		}else if(gender.equals("Female")) {
			femaleBtn.click();
		}else {
			maleBtn.click();//default value to be selected
		}
	}
	public void CompanyName(String company) 
	{
		companyBtn.sendKeys(company);
	}
	public void SaveButton() 
	{
		saveBtn.click();
	}
	
}
