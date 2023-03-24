package testComponent;

import org.testng.annotations.BeforeClass;

import baseComponent.BaseClass;

public class DeletePageTest extends BaseClass{

	@BeforeClass
	public void setupDeletePage() throws Exception {

		lp.vaildLoginPage(getExceldata("loginPage", 0, 0), getExceldata("LoginPage", 1, 0));
		hp=lp.vaildLoginButton();
		ncp=hp.clickNewCustomerTab();
		dp=ncp.ClickDeletecustomer();
	}
	
	
}
