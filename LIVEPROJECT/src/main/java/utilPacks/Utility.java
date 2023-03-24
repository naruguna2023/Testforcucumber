package utilPacks;

import java.io.FileInputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Utility {
	public static String Userdirectory;
	public static WebDriver driver;
	public static void browserlaunch(String br) {
		try {
			if(br.equalsIgnoreCase("chrome")) {
		        WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
			else if(br.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
			}
			
			else if(br.equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().setup();
				 driver = new SafariDriver();
				}
			else if(br.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				 driver = new FirefoxDriver();
			}
			
			//driver.manage().window().maximize();
			System.out.println("Browser launched succesfully");
			
		}
		catch(Exception e) {
			System.out.println("Error in browserlaunch method  " + e.getMessage());
		}
			
	}
	public static String getTitle() { 
		String s= null;//return string
		try{
			s=driver.getTitle();
			System.out.println("Title received successfully");
		}
		catch(Exception e) {
			System.out.println("Error in gettitle method" + e.getMessage());  
		}
		return s;
	}
	
	public static void getPageSrc() {   // 
		try{
			driver.getPageSource();
			System.out.println("Page Sourcereceived successfully");
		}
		catch(Exception e) {
			System.out.println("Error in getPageSrc method" + e.getMessage());
		}
	
	}
		
		public static void getUrl() {  // string return
			try{
				driver.getCurrentUrl();
				System.out.println("URL received successfully");
			}
			catch(Exception e) {
				System.out.println("Error in getURL method" + e.getMessage());
			}
		}
	
	public static WebDriver launchUrl(String url) {
		try{
			driver.get(url);
			System.out.println("Url launched successfully");
			
		}
		catch(Exception e) {
			System.out.println("Error in launchUrl "+ e.getMessage());
		}
		return driver;
		
	}
	
	public static void pageForward() {  // boolean
		try{
			driver.navigate().forward();
			System.out.println("Webpage navigated forward successfully");
		}
		catch(Exception e) {
			System.out.println("Error in pageForward" + e.getMessage());
		}
	}
	
	public static void pageBackward() {  // return bool
		try{
			driver.navigate().back();
			System.out.println("Webpage navigated backward successfully");
		}
		catch(Exception e) {
			System.out.println("Error in pageBackward" + e.getMessage());
		}
	}
	
	public static void pageRefresh() {  // return bool
		try{
			driver.navigate().refresh();
			System.out.println("Webpage refreshed  successfully");
		}
		catch(Exception e) {
			System.out.println("Error in pageRefresh" + e.getMessage());
		}
	}
	
	public static void impWait(int time) {
		try {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		System.out.println("Implicit wait applied successfully");
		
	}
		catch(Exception e) {
			System.out.println("Error in impWait method "+ e.getMessage());	
				
		}
	}
	public static boolean sendValue(WebElement element ,String value) {   
		boolean flag= false;
			try{
				element.sendKeys(value);
				System.out.println("Value enterd successfully");
				flag = true ;
			}
		
		catch(Exception e) {
			System.out.println("Error in sendValue method "+ e.getMessage());	
		}
			return flag;
		
	}
	
	public static void maximise() {
		try {
			driver.manage().window().maximize();
			System.out.println("Page maximised successfully");
		}
		catch(Exception e ) {
			System.out.println("Error in maximize method "+ e.getMessage());
			
		}
	}
	
	public static WebElement locToWebElement(By loc) {
		WebElement l =null;
		try{
			l =driver.findElement(loc);
			System.out.println("Locator converted into WebElement successfully");
	
		}
		catch(Exception e) {
			System.out.println("Error in locToWebElement method "+ e.getMessage());		
		}
		return l;
	}
	public static WebElement xpathToWebElemnt(String loc) {
		WebElement l =null;
		try{
			l =driver.findElement(By.xpath(loc));
			System.out.println("xpath converted to Webelement successfully");
			}
		catch(Exception e) {
			System.out.println("Error in xpathToWebElemnt method "+ e.getMessage());	
		}
		return l;
	}
	public static List<WebElement> locToListofElement(By loc){
		List<WebElement> ld=null;
		try {
			ld=driver.findElements(loc);
			System.out.println("locator is converted to list of element successfully");
		}
		catch(Exception e) {
			System.out.println("Error in locToListOfElement method "+ e.getMessage());		
		}
		return ld;
	}
	
	
	
	
	public static boolean bootStrap(List<WebElement> ls, String value) {
		boolean flag=false;
	try {
		for(WebElement dr: ls) {
			if(	dr.getText().equalsIgnoreCase(value)) {
				dr.click();
			}
			flag= true;
		}
		System.out.println("BootStrap method executed successfully");
		
		
	
	}
	catch(Exception e ) {
		System.out.println("Error in bootstrap method" + e.getMessage());
		
	}
	return flag;
	}
	
	
	
	
	public static void randomClick() {
		try {
			Actions actions = new Actions(driver);

			actions.click().build().perform();
			System.out.println("Random click performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in action method" + e.getMessage());
		}
	}
	public static void draganddrop(WebElement src,WebElement trg) {
		try {
			Actions actions = new Actions(driver);

			actions.dragAndDrop(src, trg).click().build().perform();
			System.out.println("Drag and Drop performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in  draganddrop  method" + e.getMessage());
		}
	}
	
	public static void doubleclick(WebElement element) {   // bool
		try {
			Actions actions = new Actions(driver);

			actions.doubleClick(element);
			System.out.println("Double click performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in  double click  method" + e.getMessage());
		}
	}
	
	public static void mouseHover(WebElement src,WebElement trg) {  // bool
		try {
			Actions actions = new Actions(driver);

			actions.clickAndHold(src).moveToElement(trg).release().perform();
			System.out.println("Mousehover performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in  mouseHover  method" + e.getMessage());
		}
	}
	
	
	
	public static String gettext(WebElement element) {
		String text="";
		try {
			text=element.getText();
			System.out.println("text received successfully");
		}
		catch(Exception e) {
			System.out.println("Error in textmethod" + e.getMessage());
		}
		return text;
	}
		
	
	
	public static void scrollDownPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			System.out.println("scrollDownPage performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in scrollDownPage method" + e.getMessage());
		}
	}
	
	public static void scrollUpPage() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-250)", "");
			System.out.println("scrollUpPage performed successfully");
		}
		catch(Exception e) {
			System.out.println("Error in scrollUPage method" + e.getMessage());
		}
	}
	
	public static void dropdownByGetOptions(WebElement element, String value) {
		try {
		Select s = new Select(element);
		List<WebElement> ls1 = s.getOptions();
		for(WebElement dr1: ls1) {
			if(	dr1.getText().equalsIgnoreCase(value)) {
				dr1.click();
			}
		}
		System.out.println(element + "dropdownByGetOptions performed successfully");
	}
	catch(Exception e) {
		System.out.println(element + "Error in dropdownByGetoptions method" + e.getMessage());
	}
	}
	
	public static void dropdownByvalue(WebElement element, String value) {
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			System.out.println(element + "dropdownByValue performed successfully");
		}
		catch(Exception e) {
			System.out.println(element + "Error in dropdownByValue method" + e.getMessage());
		}
	}
	
	public static void dropdownByindex(WebElement element,int value) {
		try {
			Select s = new Select(element);
			s.selectByIndex(value);
			System.out.println(element + "dropdownByindex performed successfully");
		}
		catch(Exception e) {
			System.out.println(element + "Error in dropdownByindex method" + e.getMessage());
		}
	}
	
	public static void dropdownByVisibleText(WebElement element,String value) {  // bool
		try {
			Select s = new Select(element);
			s.selectByVisibleText(value);
			System.out.println(element + "dropdownByvisibletext performed successfully");
		}
		catch(Exception e) {
			System.out.println(element + "Error in dropdownByvisibletext method" + e.getMessage());
		}
	}
	
	public static String generatePwd() {
		String pwd="";
		try {
			
			 pwd ="123456";
		}
		
		catch(Exception e) {
			System.out.println( "Error in generatePwd method" + e.getMessage());
		}
		return pwd;
	}
	
		
	public static void Close() {
		try {
			driver.close();
			System.out.println("Page closed Successfully..!!");
		}
		
		catch(Exception e) {
			System.out.println("Error in page closing method "+ e.getMessage());
		}
	}
	
	
	// Method 1
	public static String intToString(int n) {
		String s = null;
		try {
			s = String.valueOf(n);
			System.out.println("Int to string Converted Successfully");
		} 
		catch (Exception e) {

			System.out.println("Error in Int to String method " + e.getMessage());
		}
		return s;
	}

	// Method 2
	public static int stringToInt(String s) {
		int n = 0;
		try {
			n = Integer.parseInt(s);
			System.out.println("String to int converted successfully");
		} catch (Exception e) {

			System.out.println("Error in stringToInt method" + e.getMessage());
		}
		return n;
	}

	// Method 3
	public static boolean CompareString(String Expected, String Actual) {
		if (Expected == null) {
			return Actual == null;
		} else
			return Expected.equalsIgnoreCase(Actual);  // return t or flase
														// Sos stmts 

	}

	// Method 4
	public static boolean CompareInt(int Expected, int Actual) {

		if (Expected == 0) {

			return Actual == 0;
		} else
			return Expected == Actual;
	}

	// Method 5
	public static String randomnumberGenerator(int a) {
		//int n = 0;
		String number = "";

		try {
			Random r = new Random();
			
			for (int i = 1; i <= a; i++) {
				number += String.valueOf(r.nextInt(9));
			}
			//n = Integer.parseInt(number);
			System.out.println("Random number generated successfully");

		} catch (Exception e) {
			System.out.println("Error in random number generator" + e.getMessage());
		}
		return number;
	}

	// Method 6
	public static String randomStrGenerator(int a) {
		String m = "";
		try {
			String s = "abcdefghijklmnopqrstuvwxyz";
			Random r = new Random();

			char l;
			for (int i = 0; i < a; i++) {
				l = s.charAt(r.nextInt(s.length())); //     r.nextInt(24)  20,21,3,5,8,19   l=s.char[20];
				// System.out.print(l);
				m += l;
				
			}
			System.out.println("Random string generated suucessfully");

		} catch (Exception e) {
			System.out.println("Error in random string generator" + e.getMessage());
		}
		return m;

	}

	public static boolean ClickElement(WebElement element) {
		boolean flag =false;
		
		try {
			
			element.click();
			flag = true;
		System.out.println(" Element clicked successfully thru javamethod");
			
		}
		catch(Exception e){
			System.out.println("Error in click method " + e.getMessage());
		}
		return flag;
	}
	
	
	public static boolean JSClickElement(WebElement element) {
		boolean flag =false;
		
		try {
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			flag = true;
		System.out.println(" Element clicked thru Jss successfully");
			
		}
		catch(Exception e){
			System.out.println("Error in click method " + e.getMessage());
		}
		return flag;
	}
	
	
	// Method 7

	public static String randomEmailGenerator(int a) {
		String m = "";
		try {
			String s = "abcdefghijklmnopqrstuvwxyz";
			Random r = new Random();

			char l;
			for (int i = 0; i < 5; i++) {      			// Sysout
				l = s.charAt(r.nextInt(s.length()));
				// System.out.print(l);
				m += l;
			}
			m = m.concat("@gmail.com");
			System.out.println("Random Email Generated successfully");

		} catch (Exception e) {
			System.out.println("Error in RandomEmail generator method" + e.getMessage());   // error in  method name
		}
		return m;

	}

	// Method 8
	/*public static void Date_Time() {
		try {
			Date d = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("ddMMYYYY_hm");
			System.out.println(sd.format(d));
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}

	}*/

	// Method 9
	public static void Date() {
		try {
			Date d = new Date();				// put formatted date 
			//System.out.println(d);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}

	}

	// Method 10

	public static void wait(int a) {
		try {
			a = a * 1000;
			Thread.sleep(a);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}

	}
	
	public static String getpropvalue(String key) {
		String value = null;
		try {
			Userdirectory = System.getProperty("user.dir");
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream(Userdirectory + "//input.properties");
			prop.load(ip);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	
	
	public static String getExceldata(String sheetname, int row, int col) throws Exception

	{
		String celldata = null;
		try {
			String FilePath = Userdirectory + "//inputdata.xlsx";
			FileInputStream fis = new FileInputStream(FilePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetname);
			DataFormatter formatter = new DataFormatter();
			Cell cellformat = sh.getRow(row).getCell(col);
			celldata = formatter.formatCellValue(cellformat);
			System.out.println(celldata);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return celldata;

	}
}
