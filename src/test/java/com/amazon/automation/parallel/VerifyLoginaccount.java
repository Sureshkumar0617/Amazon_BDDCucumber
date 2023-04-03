package com.amazon.automation.parallel;

import java.util.Properties;

import org.apache.logging.log4j.Logger;

import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.pages.ProductPage;
import com.amazon.automation.pages.Verifytheaccountforlogin;
import com.amazon.automation.util.ConfigReader;
import com.amazon.automation.util.JSONUtils;
import com.amazon.automation.util.Loggers;
import com.amazon.automation.util.ScreenshotUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class VerifyLoginaccount extends DriverFactory{
	
	
	private Loggers logger;
	private ScreenshotUtility screenshotutility;
	private ConfigReader config;
	private Verifytheaccountforlogin verify;
	private JSONUtils jsonutil;
	private String[] fullClassName = this.getClass().getName().split("[.]");
	private String className = this.getClass().getName().split("[.]")[fullClassName.length - 1];
	Properties prop;

	
	@Given("as a user login for amazon website")
	public void as_a_user_login_for_amazon_website() throws Exception {

	
	

		
		logger = new Loggers();
		logger.configureLoggerSystem(new Throwable().getStackTrace()[0].getClassName());
		config = new ConfigReader(logger.loggingInstance());
		config.initprop();
		screenshotutility = new ScreenshotUtility(logger.loggingInstance());
		verify=new Verifytheaccountforlogin(getDriver(),logger.loggingInstance());

		
		getDriver().get(config.readLoginURL());

	logger.setLoggerInfo("Launching the URL");

	screenshotutility.captureScreenshot(className, "LaunchURL");

	
	
	
	
	}

	@Then("as a  user click signin")
	public void as_a_user_click_signin() throws Exception {

	verify.clickonsigin();
	logger.setLoggerInfo("ClickonSigin");
	screenshotutility.captureScreenshot(className, "Clickonsigin");

	
	}

	@Then("as a user click create a account")
	public void as_a_user_click_create_a_account() throws Exception {
		
		

	verify.clickcreateaccount();
	logger.setLoggerInfo("Clickcreateaccount");
	screenshotutility.captureScreenshot(className, "Createaccount");

	verify.clickcontinue();
	logger.setLoggerInfo("Clickconitnue");
	screenshotutility.captureScreenshot(className, "ClickContinue");

	
	}

	@Then("as a user Verify the username Validate the Message {string}")
	public void as_a_user_verify_the_username_validate_the_message(String expSucces) throws Exception {

	
		String actual = verify.verifyname();
		Assert.assertEquals(expSucces, actual);
		logger.setLoggerInfo(actual);
		screenshotutility.captureScreenshot(className, "Message1");

	}

	@Then("as a user Verify the Mobilenumber Validate the Message {string}")
	public void as_a_user_verify_the_mobilenumber_validate_the_message(String expSuccess1) throws Exception {

		String actual2 = verify.verifyemailandnumber();
		Assert.assertEquals(actual2, expSuccess1);
		logger.setLoggerInfo(actual2);
		screenshotutility.captureScreenshot(className, "Message2");

}

	@Then("as a user Verify the Password Validate the Message {string}")
	public void as_a_user_verify_the_password_validate_the_message(String expSuccess2) throws Exception {

		String actual3 = verify.verifythepassword();
		Assert.assertEquals(actual3, expSuccess2);
		logger.setLoggerInfo(actual3);
		screenshotutility.captureScreenshot(className, "Message3");

		
	
	}


	
	
	
	
}
