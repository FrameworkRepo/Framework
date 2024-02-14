package Selenium.testComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import Framework.pageObject.accountSignIn;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

	public WebDriver driver;
	
	public accountSignIn accountSignInObj;
	
	
	public WebDriver intializeBrowser() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			// Chrome

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);

			System.out.println("Successfully invoked " + browserName + " browser.");

		}

		else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

			System.out.println("Successfully invoked " + browserName + " browser.");

		}

		else {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

			System.out.println("Successfully invoked " + browserName
					+ "( Since browser name provide is not same as coded so invoked Chrome Browser. )");

		}

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;

	}

//	@BeforeMethod
	public accountSignIn openWebSite() throws IOException {

		driver = intializeBrowser();

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String webSite = prop.getProperty("website");
		
		driver.get(webSite);
		
		return accountSignInObj = new accountSignIn(driver);


	}

	public String getUserName() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String userName = prop.getProperty("username");

		return userName;

	}

	public String getPassword() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String passWord = prop.getProperty("password");
		
		return passWord;

	}
	public String getItem() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String item = prop.getProperty("item");
		
		return item;

	}
	public String getCountryName() throws IOException {

		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Framework\\Resources\\Global.Properties");
		// src\main\java\Framework\Resources\Global.properties

		prop.load(fis);

		String countryName = prop.getProperty("countryName");
		
		return countryName;

	}
	
	
	public void closeBrowser() {
		driver.close();
	}
}
