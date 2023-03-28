package parallel;

import com.pages.ProductPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.Loggers;
import com.qa.util.ScreenshotUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmazonProductStep_Definition extends Driver_Factory{

	
	private ProductPage productobj = new ProductPage(Driver_Factory.getDriver());
	private Loggers logger;
	private ScreenshotUtility screenshotutility;
private ConfigReader config;
private String[] fullClassName = this.getClass().getName().split("[.]");
private String className = this.getClass().getName().split("[.]")[fullClassName.length - 1];

	
	@Given("user is on application")
	public void user_is_on_application() throws Exception {
		
		
		logger = new Loggers();
		logger.configureLoggerSystem(new Throwable().getStackTrace()[0].getClassName());
		config = new ConfigReader(logger.loggingInstance());
		screenshotutility = new ScreenshotUtility(logger.loggingInstance());
		
		Driver_Factory.getDriver().get(ConfigReader.readLoginURL());
		
		productobj.changepincode();
		screenshotutility.captureScreenshot(className, "ChangePincode");
		logger.setLoggerInfo("Change Pincode");
		Thread.sleep(2000);
		productobj.EnterPincode();
		screenshotutility.captureScreenshot(className, "EnterPincode");
		logger.setLoggerInfo("Enter Pincode");
		Thread.sleep(2000);
		productobj.applypincode();
		screenshotutility.captureScreenshot(className, "Applypincode");
		logger.setLoggerInfo("Apply pincode");
	}

	@Then("user search the product {string}")
	public void user_search_the_product(String string) throws Exception {
		productobj.searchproduct(string);
		screenshotutility.captureScreenshot(className,"Searchproducts");
		logger.setLoggerInfo("Search products");
	}

	@Then("product add to the cart")
	public void product_add_to_the_cart() throws Exception {
		Thread.sleep(2000);
		productobj.NavigatetoCart();
		screenshotutility.captureScreenshot(className, "Navigatetocart");
		logger.setLoggerInfo("Navigate to product");
}

	@Then("user validates the product with quantity {string} in the cart")
	public void user_validates_the_product_with_quantity_in_the_cart(String string) throws Exception {
		productobj.ValidateCart(string);
		Thread.sleep(3000);
		screenshotutility.captureScreenshot(className, "Validatecart");
		logger.setLoggerInfo("validate cart");
		}

	@Then("increase the quantity of the product by {int} in cart")
	public void increase_the_quantity_of_the_product_by_in_cart(Integer int1) throws Exception {
		productobj.inputQuantity(productobj.ddquantity , "2");
		screenshotutility.captureScreenshot(className, "Inputquantity");
		logger.setLoggerInfo("Input quantity");
	}

	@Then("user deletes the product {string}")
	public void user_deletes_the_product(String string) throws Exception {
		productobj.delete(); 
		screenshotutility.captureScreenshot(className, "Deleteproduct");
		logger.setLoggerInfo("delete product");
	}

	@Then("product add to the cart to proceed to checkout")
	public void product_add_to_the_cart_to_proceed_to_checkout() throws Exception {
		Thread.sleep(2000);
	productobj.NavigatetoCheckout();
	screenshotutility.captureScreenshot(className, "Navigatetocheckout");
	logger.setLoggerInfo("Navigate to checkout");
	}

	@Then("navigate and validate the screen Select a shipping address")
	public void navigate_and_validate_the_screen_select_a_shipping_address() throws Exception {
	 
		productobj.validateshippingscreen();
		screenshotutility.captureScreenshot(className, "validatetoshippingscreen");
		logger.setLoggerInfo("validate to shipping screen");
	   productobj.navigateback();
	   screenshotutility.captureScreenshot(className, "Navigateback");
	   logger.setLoggerInfo("navigate back");
	}

	@Then("navigate to cart and validate the save later functionality")
	public void navigate_to_cart_and_validate_the_save_later_functionality() throws Exception {
	   productobj.saveforlaterandgotocart();
	   screenshotutility.captureScreenshot(className,"Saveforlater");
	   logger.setLoggerInfo("save for later");
	}

	
}
