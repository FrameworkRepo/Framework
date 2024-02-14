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

import Selenium.testComponents.baseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Originalcode {
	public WebDriver driver;

	String countryName = "India";

	@Test
	public void placeorder() throws InterruptedException, IOException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException {

		String item = "IPHONE 13 PRO";

		String site = "https://rahulshettyacademy.com/client/";

		baseTest bt = new baseTest();

		driver = bt.intializeBrowser();

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("Framework@email.com");
		driver.findElement(By.id("userPassword")).sendKeys("Selenium@2024");
		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(item)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

		List<WebElement> cartitems = driver.findElements(By.cssSelector(".cartSection h3"));

		WebElement cartitem = cartitems.stream().filter(itemcheck -> itemcheck.getText().equals(item)).findFirst()
				.orElse(null);

		System.out.println("Item added to cart : " + cartitem.getText());

		Assert.assertTrue(cartitem.getText().contains(item));

		driver.findElement(By.xpath("//*[text()='Checkout']")).click();

		driver.findElement(By.cssSelector("input[placeholder*='Country']")).sendKeys("India");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ta-item")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		Actions a = new Actions(driver);

		a.sendKeys(Keys.PAGE_DOWN).build().perform();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector(".action__submit")).click();

		Boolean orderplacedmsg = driver.findElement(By.cssSelector(".hero-primary")).getText()
				.equals("THANKYOU FOR THE ORDER.");

		Assert.assertTrue(orderplacedmsg);

		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(3000);

		driver.close();
	}

}
