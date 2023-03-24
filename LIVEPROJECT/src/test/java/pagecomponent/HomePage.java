package pagecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import utilPacks.Utility;

public class HomePage extends Utility {
	public WebDriver driver;

	@FindBy(xpath = "//a[text()='New Customer']")
	WebElement NewCustomer;
	
    public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void headerExists() {
		System.out.println(getTitle());
	}
	
	public NewCustomerPage clickNewCustomerTab() {
		Assert.assertEquals(true,  ClickElement(NewCustomer));
		return new NewCustomerPage(driver);
	}
}