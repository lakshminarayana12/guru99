package genric;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class Basetest implements IAutoconst {
	public static WebDriver driver;
	static {
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
@BeforeMethod
public void openapplication() {
	driver = new FirefoxDriver();
	String url=Lib.getproperty(CONFIG_PATH, "URL");
	System.out.println("url "+url);
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}



//@AfterMethod
//public void closeApplication() {
//	driver.quit();
//}

}
