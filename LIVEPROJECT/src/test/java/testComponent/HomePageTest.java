package testComponent;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseComponent.BaseClass;

public class HomePageTest extends BaseClass {
@BeforeClass
public void setupHomePage() throws Exception {

	lp.vaildLoginPage(getExceldata("loginPage", 0, 0), getExceldata("LoginPage", 1, 0));
	hp=lp.vaildLoginButton();
}

 
@Test
public void clickNewCustomer() {
	ncp=hp.clickNewCustomerTab();
}
@Test
public void getTheTitile() {
	ncp.getAccountsPageTitle(); 
}
}
