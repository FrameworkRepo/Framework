package Selenium.Test;

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
import Selenium.testComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class placeOrderTest extends baseTest {
		

	@Test
	public void placeorder() throws InterruptedException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		baseTest bt = new baseTest();
		
		String countryName = bt.getCountryName();
		
		String item = bt.getItem();
		
		String userName = bt.getUserName();
		
		String password = bt.getPassword();
		
		accountSignIn accountSignInObj = bt.openWebSite();
				
		addToCart addToCartobj = accountSignInObj.signIn(userName,password );
		
		checkOut checkOutobj = addToCartobj.addItemToCart(item);

//		Assert.assertTrue(cartitem.getText().contains(bt.getItem()));
		
		Boolean orderplacedmsg = checkOutobj.checkOutPage(countryName).equals("THANKYOU FOR THE ORDER.");

		Assert.assertTrue(orderplacedmsg);
		
		bt.closeBrowser();
	}

}
