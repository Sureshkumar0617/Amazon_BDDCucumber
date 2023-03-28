package AppHooks;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.Driver_Factory;
import com.qa.util.ConfigReader;
import com.qa.util.ElementUtil;
import com.qa.util.Generic_Functions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Application_Hooks extends Driver_Factory{

	private Driver_Factory driverFactory;
	private WebDriver driver;
	Properties prop;

	public static Scenario scenario;


	@Before()
	public void launchBrowser(Scenario scenario) {
			driverFactory = new Driver_Factory();
		try {
			driver = driverFactory.init_driver(ConfigReader.readBrowser());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	@AfterStep
	public void as(Scenario scenario) throws Exception
	{

	scenario.attach(new Generic_Functions().getByteScreenshot(), "image/png", "anyname");
	}


		@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}




	@After(order = 1)
	public void tearDown(Scenario scenario) throws Exception {
		String exeTime = new SimpleDateFormat("ddMMYYYYHH").format(new Date());
		try {
			if (scenario.isFailed()) {
				String screenshotName = scenario.getName().replaceAll(" ", "_");
				byte[] sourcePath = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(sourcePath, "image/png", screenshotName);

				TakesScreenshot ts = (TakesScreenshot) getDriver();
				File source = ts.getScreenshotAs(OutputType.FILE);
				String fileLocation = System.getProperty("user.dir") + "\\" + "test-output\\";

				String recentCreatedFile = ElementUtil.getfolder(fileLocation);
				File f = new File(recentCreatedFile);

				if (f.exists()) {
					FileUtils.copyFile(source,
							new File(recentCreatedFile + "\\" + "Screenshot_Failed", screenshotName + ".png"));
				} else {
					f.mkdir();
					FileUtils.copyFile(source, new File(fileLocation + "\\" + "Screenshot_Failed" + "\\" + exeTime,
							screenshotName + ".png"));
				}
			}
		} catch (Exception e) {

		}
	}
}