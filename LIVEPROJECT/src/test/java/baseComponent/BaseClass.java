package baseComponent;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pagecomponent.DeletePage;
import pagecomponent.HomePage;
import pagecomponent.LoginPage;
import pagecomponent.NewCustomerPage;
import utilPacks.Utility;

public class BaseClass extends Utility {
	
	public NewCustomerPage ncp;
	public HomePage hp ;
	public LoginPage lp;
	public DeletePage dp;
	
	@BeforeTest
	  public void beforeMethod() {
		  browserlaunch("chrome");
		  driver=launchUrl(getpropvalue("URL"));
		  impWait(30);
		  maximise();
		  lp= new LoginPage(driver);
	}
	

	  @AfterTest
	  public void afterMethod() {
		//  Close();
	  }
}
