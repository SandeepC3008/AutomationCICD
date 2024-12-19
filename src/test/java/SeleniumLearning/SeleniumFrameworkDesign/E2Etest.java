package SeleniumLearning.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.TestComponents.BaseTest;
import SeleniumLearning.DataStorage.DataReader;
import SeleniumLearning.pageObjects.CartPage;
import SeleniumLearning.pageObjects.ConfirmationPage;
import SeleniumLearning.pageObjects.LandingPage;
import SeleniumLearning.pageObjects.ProductCatlogue;

public class E2Etest extends BaseTest{
	
	@Test (dataProvider = "TestData")
	public void E2Etest(HashMap<String,String> input) throws InterruptedException, IOException {

	//public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//String Prodname = "ADIDAS ORIGINAL";
		
		LandingPage landingpage = new LandingPage(driver);//we are using this to make sure that we can use the same driver in other class called Landingpage
		landingpage.Goto("https://rahulshettyacademy.com/client");
		landingpage.loginApplication(input.get("Email"), input.get("Password"));//here we are calling the object with the class name and sending the data
		
		ProductCatlogue ProductCat = new ProductCatlogue(driver);
		List <WebElement>items= ProductCat.getProductList();
		ProductCat.AddtoCart(input.get("Prodname"));
		ProductCat.GoToCart();
		
		CartPage cartpage = new CartPage(driver);
		Boolean Result = cartpage.VerifyProductDisplay(input.get("Prodname"));
		Assert.assertTrue(Result);
		cartpage.countryvalue();
		
		
		
		
		ConfirmationPage ConfirmPag = new ConfirmationPage(driver);
		String Text = ConfirmPag.Confirm();
		Assert.assertEquals(Text, "THANKYOU FOR THE ORDER.");
		
		
		
		driver.close();
		


	}
	
	@DataProvider
	
	
	//the below steps are to send the data in array
	/*public Object[][] TestData()
	{
		Object[][] Data = new Object[2][3];
		Data[0][0]="sandeep.c07@gmail.com";
		Data[0][1]="1JS18ME079@s";
		Data[0][2]="ZARA COAT 3";
		
		
		Data[1][0]="sandeep.c08@gmail.com";
		Data[1][1]="1JS18ME079@s";
		Data[1][2]="ADIDAS ORIGINAL";
		
		return Data;*/
	
	//the below are the steps to read data from the jason
	
	public Object[][] TestData() throws IOException
	{
		
		//WE are creating a new object to catch the hash map created
		DataReader Dreader = new DataReader();
		//in the below we are sending the file path and getting the list 
		List<HashMap<String ,String>> data =Dreader.GetJsonToHashMap(System.getProperty("user.dir")+"/src/test/java/SeleniumLearning/DataStorage/E2ETesting.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	
	
		
	}
	
	public String GetScreenshot(String Testcasename) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		ts.getScreenshotAs(OutputType.FILE);//her we are telling the output of screenshot should be file
		File file = new File(System.getProperty("user.dir")+Testcasename+".png");
		FileUtils.copyFile(file, file);
		return System.getProperty("user.dir")+Testcasename+".png" ;
	}
	

}
