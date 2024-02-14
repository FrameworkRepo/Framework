package Selenium.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Framework.pageObject.accountSignIn;
import Framework.pageObject.addToCart;
import Framework.pageObject.checkOut;
import Selenium.testComponents.Retry;
import Selenium.testComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class errorValidationTest extends baseTest {
		

	@Test(retryAnalyzer=Retry.class)
	public void ErrorValidation() throws InterruptedException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		baseTest bt = new baseTest();
				
		accountSignInObj.signIn("Framework@email.com","se" );
		
		String error = driver.findElement(By.cssSelector(".toast-message")).getText();
		
		Assert.assertTrue(error.equals("Incorrect email or passwod"));
		
		System.out.println("Added this line from downloaded and made changes");
		System.out.println("Added this line from downloaded and made changes1");
		System.out.println("Added this line from downloaded and made changes2");
		
		Thread.sleep(3000);
	}



}
