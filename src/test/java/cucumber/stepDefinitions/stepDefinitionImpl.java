package cucumber.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Framework.pageObject.accountSignIn;
import Framework.pageObject.addToCart;
import Framework.pageObject.checkOut;
import Selenium.testComponents.baseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionImpl {

	public accountSignIn accountSignInObj;

	public addToCart addToCartobj;

	public checkOut checkOutobj;

	baseTest bt = new baseTest();

	@Given("I landed on ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {

		accountSignInObj = bt.openWebSite();

	}

	@Given("^logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username, String password) {

		addToCartobj = accountSignInObj.signIn(username, password);

	}

	@When("^Add Item(.+) to the cart and submit the order$")
	public void add_item_to_the_cart_and_submit_the_order(String item) {

		checkOutobj = addToCartobj.addItemToCart(item);

	}

	@Then("{string} verify the message on confirmationPage")
	public void message_check_on_confirmation_page() throws InterruptedException, IOException {

		String countryName = bt.getCountryName();
		Boolean orderplacedmsg = checkOutobj.checkOutPage(countryName).equals("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(orderplacedmsg);

		bt.closeBrowser();
	}

}
