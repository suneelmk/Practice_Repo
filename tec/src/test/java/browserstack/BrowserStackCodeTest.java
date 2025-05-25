package browserstack;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class BrowserStackCodeTest {

	@Test
	public void sampleTest() throws MalformedURLException {
		String username = "sunilkittali_kB57EL";
		String password = "kroKd5QYsMieyWHTkYty";
		
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
		capabilities.setCapability("browserName", "Firefox");
		bstackOptions.put("os", "Windows");
		bstackOptions.put("osVersion", "10");
		bstackOptions.put("browserVersion", "120.0");
		
		bstackOptions.put("consoleLogs", "info");
		capabilities.setCapability("bstack:options", bstackOptions);


		RemoteWebDriver driver = new RemoteWebDriver(
				new URL("https://" + username + ":"+ password +"@hub-cloud.browserstack.com/wd/hub"), capabilities);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.close();
         
	}
}
