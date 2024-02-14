package Framework.AbstractComponenets;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	// Reusable code

	WebDriver driver;

	boolean check = false;
	
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
	}

	public void explicitWaitVisiblityOfElement(By locatorInfo) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locatorInfo));
	}

	public void explicitWaitInVisiblityOfElement(By locatorInfo) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(locatorInfo));
	}
	
	public boolean explicitWaitelementToBeClickable(By locatorInfo) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		if(wait.until(ExpectedConditions.elementToBeClickable(locatorInfo)) != null)
		{
			return true;
		}
		return false;
	}

	public void codeSleep() throws InterruptedException {

		Thread.sleep(2000);
	}
	public void actionsToPerformPageDown()  {
		
		Actions a = new Actions(driver);
		
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	public void actionsToPerformPageUp()  {
		
		Actions a = new Actions(driver);
			
		a.sendKeys(Keys.PAGE_UP).build().perform();
	}

	public boolean isElementDisplayed(By findBy) {

		return driver.findElement(findBy).isDisplayed();

	}

//	public boolean elementtoBeClickable(By findBy) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//		return wait.until(ExpectedConditions.elementToBeClickable(findBy)) != null;
//	}

	public boolean isDisplayed(By locatorinfo) {

		try {

			check = driver.findElement(locatorinfo).isDisplayed();

			return check;

		}

		catch (Exception e) {

			return false;

		}

	}

	public void takeScreenshot() throws IOException {

		File fileObj = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(fileObj, new File("PlaceOrder.png"));
	}

}
