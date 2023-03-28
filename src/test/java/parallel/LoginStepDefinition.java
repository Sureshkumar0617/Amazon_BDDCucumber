package parallel;

	import java.io.IOException;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.Loggers;
import com.qa.util.ScreenshotUtility;

import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;

	public class LoginStepDefinition {

		private LoginPage loginPage = new LoginPage(Driver_Factory.getDriver());
		private Loggers logger;
		private ScreenshotUtility screenshotutility;
	private ConfigReader config;
	private String[] fullClassName = this.getClass().getName().split("[.]");
	private String className = this.getClass().getName().split("[.]")[fullClassName.length - 1];


		@Given("user is on login page")
		public void user_is_on_login_page() throws Exception {

			
			logger = new Loggers();
			logger.configureLoggerSystem(new Throwable().getStackTrace()[0].getClassName());
			config = new ConfigReader(logger.loggingInstance());
			screenshotutility = new ScreenshotUtility(logger.loggingInstance());

			Driver_Factory.getDriver().get(ConfigReader.readLoginURLIndia());
			loginPage.clickonsigin();
			screenshotutility.captureScreenshot(className, "Clicksignin");
			logger.setLoggerInfo("Click on Sign");
		}

		@When("user enter Username")
		public void user_enter_username() throws Exception {
			loginPage.enterUserName(ConfigReader.readuserid1());
			screenshotutility.captureScreenshot(className, "EnterUsername");
			logger.setLoggerInfo("Enter Username");
			loginPage.clickoncontinue();
			screenshotutility.captureScreenshot(className, "Clickcontinue");
			logger.setLoggerInfo("Click continue");
			
		}

		@When("user enter Password")
		public void user_enter_password() throws Exception {
			loginPage.enterPassword(ConfigReader.readpswrd1());
			screenshotutility.captureScreenshot(className, "EnterPassword");
			logger.setLoggerInfo("Enter Password");

		}
		@Then("forgot your password link should be displayed")
		public void forgot_your_password_link_should_be_displayed() throws Exception {
			Assert.assertFalse(loginPage.isForgotPwdLinkExist());
			screenshotutility.captureScreenshot(className, "CheckMessage");
			logger.setLoggerInfo("Check Message");

		
		}

					
		}

