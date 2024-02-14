package Framework.pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.AbstractComponenets.AbstractComponent;

public class addToCart extends AbstractComponent {
	
	WebDriver driver;

	public addToCart(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By waitEle =By.cssSelector(".mb-3");
	
	By productNameEle =By.cssSelector("b");
	
	By productClickEle =By.cssSelector(".card-body button:last-of-type");
	By toastEle =By.cssSelector("#toast-container");
	By animatingEle =By.cssSelector(".ng-animating");
	
	
	@FindBy(css=".mb-3")
	List<WebElement> productsEle;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartitemsEleList;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartButtonEle;
	
	public checkOut addItemToCart(String item){
		
		explicitWaitVisiblityOfElement(waitEle);
		
		WebElement prod = productsEle.stream()
				.filter(product -> product.findElement(productNameEle).getText().equals(item)).findFirst()
				.orElse(null);

		prod.findElement(productClickEle).click();

		explicitWaitVisiblityOfElement(toastEle);
		
		explicitWaitInVisiblityOfElement(animatingEle);

		cartButtonEle.click();

		WebElement cartitem = cartitemsEleList.stream().filter(itemcheck -> itemcheck.getText().equals(item)).findFirst()
				.orElse(null);

		System.out.println("Item added to cart : " + cartitem.getText());
		
		checkOut checkOutobj = new checkOut(driver);
		
		return checkOutobj;
	}
	

}
