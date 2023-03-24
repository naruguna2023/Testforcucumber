package pagecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilPacks.Utility;

public class LoginPage extends Utility{
	public WebDriver driver;

	@FindBy(xpath = "//input[@name='uid']")
	WebElement UserPath;

	@FindBy(xpath = "//input[@type='password']")
	WebElement PassPath;

	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement ButtonPath;
	
	@FindBy(xpath = "//input[@type='reset']")
	WebElement ResetButton;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void vaildLoginPage(String Username, String Password) throws Exception {
		Assert.assertEquals(true, sendValue(UserPath, Username));
		Assert.assertEquals(true, sendValue(PassPath, Password));
		
	} 

	public HomePage vaildLoginButton() throws Exception {
		Assert.assertEquals(true,  ClickElement(ButtonPath));
		return new HomePage(driver);
	}

}
