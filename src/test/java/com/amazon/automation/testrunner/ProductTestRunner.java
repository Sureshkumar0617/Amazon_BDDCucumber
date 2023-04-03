package com.amazon.automation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt",
				"json:target/cucumber-reportreport.json"},
		monochrome = true,
		publish = true,
		glue = {"com/amazon/automation/parallel","com/amazon/automation/apphooks" },
		features = {"./src/test/resources/parallel/Product2Cart.feature"}
		)


public class ProductTestRunner extends AbstractTestNGCucumberTests{
	
	
	}

