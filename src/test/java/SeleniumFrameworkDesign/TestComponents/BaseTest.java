package SeleniumFrameworkDesign.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import SeleniumLearning.pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver; 
	public WebDriver initilizeBrowser() throws IOException
	{
		
		//we have created a properties file and to call that we need to create s object
		
		Properties prop = new Properties();
		FileInputStream Fip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/SeleniumLearning/Resources/GlobalData.properties");
		//in the above we have created a obeject to convert the properties file into a inputstream 
		//System.getProperty("user.dir") whe have used this to get the project path automatically 
		prop.load(Fip);
		String BrowserName = prop.getProperty("browser");//here we are getting the details from the property file 
		
		
		
		if(BrowserName.contains("Chrome"))
		{
		driver = new ChromeDriver();
		
		}
		else if (BrowserName.contains("Firefox"))
		{
			//firefox invoking code
		}
		else if (BrowserName.contains("Edge"))
		{
			//edge invoking code
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
		
	}
	
	

	public LandingPage LaunchApplication() throws IOException {
		// TODO Auto-generated method stub
		//driver = initilizeBrowser();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.Goto("https://rahulshettyacademy.com/client");
		return landingpage;
		
		
	}
	
	

}


