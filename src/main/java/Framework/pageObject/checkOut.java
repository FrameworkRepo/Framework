package Framework.pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Framework.AbstractComponenets.AbstractComponent;

public class checkOut extends AbstractComponent {
	
	WebDriver driver;
	
	public checkOut(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//*[text()='Checkout']")
	WebElement checkOutEle;
	
	@FindBy (css="input[placeholder*='Country']")
	WebElement countryNameEle;
	
	@FindBy (xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryNameChooseEle;
	
	@FindBy (css=".action__submit")
	WebElement submitEle;
	@FindBy (css=".hero-primary")
	WebElement orderPlacedCheckEle;
	
	By countryLoc= By.cssSelector(".ta-item");
	
	
	public String checkOutPage(String countryName) throws InterruptedException, IOException{
		
		checkOutEle.click();

		countryNameEle.sendKeys(countryName);

		if(explicitWaitelementToBeClickable(countryLoc)){

			countryNameChooseEle.click();
		}
		actionsToPerformPageDown();

		codeSleep();
		
		submitEle.click();
		
		actionsToPerformPageUp();

		String orderplacedmsg = orderPlacedCheckEle.getText();
		
		codeSleep();
		
		takeScreenshot();
		
		return orderplacedmsg;
	}


}
