package elementPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElemUtil1 {
private WebDriver driver;

public ElemUtil1(WebDriver driver) {
	this.driver = driver;
}

public By stringMeth(String type, String val) {
	By loc = null;
	switch(type) {
	case "id":
		loc = By.id(val);
		break;
	case "name":
		loc = By.id(val);
		break;
	case "xpath":
		loc = By.xpath(val);
		break;
		default :
			System.out.println("enter a value");
		
	}
	return loc;
}
public WebElement getElement(By l) {
	return driver.findElement(l);
}
public void dosendKeys(By l, String text) {
	getElement(l).sendKeys(text);
}

}
