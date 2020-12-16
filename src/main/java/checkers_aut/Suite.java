package checkers_aut;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Suite {
	
	public static WebDriver driver;
	public static String fileProperties = "resources/config.properties";
	public static String URL = "";
	public static String BROWSER = "";
	public static String RESULT = "OK";
		

	/**
     * <b>Name:</b> loadProperties</br></br>
     * <b>Description:</b> 	Load the properties contained in the framework configuration file
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void loadProperties() {
		System.out.println("Automated test start");
		Properties prop = new Properties();
		try {
			String file = fileProperties;
			prop.load(new FileInputStream(file));
		    URL = prop.getProperty("url");
			BROWSER = prop.getProperty("browser");
		} catch (Exception e) {
			Suite.RESULT = e.getMessage();
			fail("Exception: " + e.getMessage());
		}
	}
	
	/**
     * <b>Name:</b> goToLocation</br></br>
     * <b>Description:</b> 	This method indicates the driver the URL to load the website or application, 
     * it also waits for the page to load and maximizes the browser
     * @return void
     * @author Ignacio Sagredo
     **/
	public static void goToLocation()
	{
		try {
			
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		} catch (Exception e) {
			Suite.RESULT = e.getMessage();
			System.out.println(e.getMessage());
		}
	}
	

	
	
}
