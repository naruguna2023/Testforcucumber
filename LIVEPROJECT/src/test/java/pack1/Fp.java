package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fp {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();//driver launch
	WebDriver driver = new ChromeDriver();//chrome browser launch
	driver.get("https://www.google.com/");//launch url
	WebElement e=driver.findElement(By.xpath("//input[@name='q']"));
	e.sendKeys("testing");
	e.sendKeys(Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='Images']")).click();
	
	
	
}
}
