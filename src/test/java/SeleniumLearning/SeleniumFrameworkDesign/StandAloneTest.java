package SeleniumLearning.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("sandeep.c08@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("1JS18ME079@s");
		driver.findElement(By.id("login")).click();
		//LandingPage landingpage = new LandingPage(driver);//we are using this to make sure that we can use the same driver in other class called Landingpage
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		//we now need to click add to cart for the required product
		String Prodname = "ADIDAS ORIGINAL";
		List<WebElement> Items=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement Prod =  Items.stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(Prodname)).findFirst().orElse(null);
		/*
		 * we have used streams to filter based on the text and store it into a webelement
		 */
		Prod.findElement(By.cssSelector(".card-body button.w-10")).click();
		
		
		//below we have used explicit wait to wait till we get the message popup after we click on add to cart
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		
		//below we are using explicit wait to wait till the loading icon starts after we click on add to cart
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));	
		
		//below we are using explicit wait to wait till the loading icon closes after we click on add to cart
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
	    //now we need to verify if the selected item is there in cart or not
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List <WebElement> CartProd = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean Result = CartProd.stream().anyMatch(finalprod->finalprod.getText().equalsIgnoreCase(Prodname));
		
		Assert.assertTrue(Result);
		
		driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
		
		
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
		//we are using explicit wait untill the drop down is available
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		
		
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		
		driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
		
		String FinalMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(FinalMessage) ;
		
		Assert.assertEquals(FinalMessage, "THANKYOU FOR THE ORDER.");
		
		driver.close();
		


	}

}
