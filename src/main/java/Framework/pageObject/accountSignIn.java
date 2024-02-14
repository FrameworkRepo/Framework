package Framework.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponenets.AbstractComponent;
import Selenium.testComponents.baseTest;

public class accountSignIn extends AbstractComponent {
	
	public WebDriver driver;
	
	public addToCart addToCartobj;
	
	public accountSignIn(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement userNameEle;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement loginEle;
		
	public addToCart signIn(String userName, String Password){
				
		userNameEle.sendKeys(userName);
		
		passwordEle.sendKeys(Password);
		
		loginEle.click();
		
		addToCartobj = new addToCart(driver);
		
		return addToCartobj;
		
		
	}

}
