package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();

	/*This method is used to initialize ThreadLocalDriver on the basis of given browser*/
	public WebDriver init_driver(String browser){
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			//Setting ChromeDriverObject to Thread Local Drive so that it keeps local driver copy for specific thread
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			//Setting FirefoxDriverObject to Thread Local Drive so that it keeps local driver copy for specific thread
			tlDriver.set(new FirefoxDriver());
		}
		else{
			System.out.println("Please pass the correct browser value " + browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
        return getDriver();
	}

	/*This method is used to get the driver with threadlocal*/
	public static synchronized WebDriver getDriver(){
		return tlDriver.get();
	}
}
