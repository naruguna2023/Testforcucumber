package pagecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilPacks.Utility;

public class DeletePage extends Utility {
public WebDriver driver;


public DeletePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void headerExists() {
	System.out.println(getTitle());
}

}
