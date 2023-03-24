package pagecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilPacks.Utility;

public class NewCustomerPage extends Utility {
	public WebDriver driver;
	@FindBy(xpath = "//input[@name='name']")
	WebElement Name;
	@FindBy(xpath = "//td[text()='Gender']//following-sibling::td//child::input[2]")
	WebElement Gender;
	@FindBy(xpath = "//input[@type='date']")
	WebElement Date;
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement Address;
	@FindBy(xpath = "//input[@name='city']")
	WebElement City;
	@FindBy(xpath = "//input[@name='state']")
	WebElement State;
	@FindBy(xpath = "//a[text()='Delete Customer']")
	WebElement DelCustomer;
	public NewCustomerPage(WebDriver driver)  {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getAccountsPageTitle() {
		String o=getTitle();
		System.out.println(o);
		
		 
	}
	public void enterName(String name) throws Exception {
		Assert.assertEquals(true, sendValue(Name, name));
	}
	public void enterGender() {
		Assert.assertEquals(true, ClickElement(Gender));
	}
	public void enterDate(String date) throws Exception {
		Assert.assertEquals(true, sendValue(Date, date));
	}	
	public void enterAddress(String addr) throws Exception {
		Assert.assertEquals(true, sendValue(Address, addr));
	}
	public DeletePage ClickDeletecustomer() {
		Assert.assertEquals(true,  ClickElement(DelCustomer));
		return new DeletePage(driver);
	}
}
