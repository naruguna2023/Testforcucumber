package testComponent;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseComponent.BaseClass;

public class NewCustomerTest extends BaseClass {
	@BeforeClass
	public void newCustomerSetup() throws Exception {
		lp.vaildLoginPage(getExceldata("loginPage", 0, 0), getExceldata("LoginPage", 1, 0));
		hp=lp.vaildLoginButton();
		ncp=hp.clickNewCustomerTab();
	}
	
	@Test(priority=0)
	public void titleTest() {
		ncp.getAccountsPageTitle();
	} 
	@Test(priority=1)
	public void testcase1() throws Exception {
		ncp.enterName(getExceldata("Add", 0, 0));
	} 
	@Test(priority=2)
	public void testcase2() {
		ncp.enterGender();
	}
	@Test(priority=3)
	public void testcase3() throws Exception {
		ncp.enterDate(getExceldata("Add", 1, 0));
	}
	@Test(priority=4)
	public void testcase4() throws Exception {
		ncp.enterAddress(getExceldata("Add", 2, 0));
	}
	@Test(priority =5)
	public void testcase5() {
		dp=ncp.ClickDeletecustomer();
	}
	
	public void deleteheader() {
		dp.headerExists();
	}
}

