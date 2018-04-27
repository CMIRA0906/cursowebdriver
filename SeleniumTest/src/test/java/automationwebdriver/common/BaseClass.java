package automationwebdriver.common;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public WebDriver driver;
	
	public String browser ="chrome";
	
	public String urlBase="http://automatizacion.herokuapp.com/pperez/";
	
	@Before
	public void iniciarNavegador(){
		
		
		switch (browser) {
		case "firefox":
			
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
			break;
			
		case "chrome":
			
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
			
			break;
			
		case "explorer":
			
			System.setProperty("webdriver.ie.driver", "drivers/MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			
			
			break;

		default:
			break;
		}
		
		//Espera implicita
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@After
	public void cerrarNavegador(){
		
		//driver.quit();
		driver.close();
	}
	
	

}
