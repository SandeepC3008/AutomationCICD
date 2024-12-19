package SeleniumLearning.SeleniumFrameworkDesign;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumLearning.pageObjects.LandingPage;

public class ErrorValidation extends BaseTest{
	
	@Test
	public void E2Etest() throws InterruptedException, IOException {

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		String Prodname = "ADIDAS ORIGINAL";
		
		LandingPage landingpage = new LandingPage(driver);//we are using this to make sure that we can use the same driver in other class called Landingpage
		landingpage.Goto("https://rahulshettyacademy.com/client");
		landingpage.loginApplication("sandeep.c07@gmail.com", "1JS18ME079");//here we are passing the wrong password
		
		AssertJUnit.assertEquals("Incorrect email or password.", landingpage.GetErrorMessage());
		
		driver.close();
		
		
		
		
		
		
		
		


	}

}
