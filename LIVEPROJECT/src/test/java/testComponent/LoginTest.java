package testComponent;

import org.testng.annotations.Test;

import baseComponent.BaseClass;
import pagecomponent.HomePage;
import pagecomponent.LoginPage;



	public class LoginTest extends BaseClass {
		@Test
		public void Testcase1() throws Exception {
			lp.vaildLoginPage(getExceldata("loginPage", 0, 0), getExceldata("LoginPage", 1, 0));
			hp=lp.vaildLoginButton();	
		}
		@Test
		public void getHomepagetitle() {
			hp.headerExists();
		}
} 
 