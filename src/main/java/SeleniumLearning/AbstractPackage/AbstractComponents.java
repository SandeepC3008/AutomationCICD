package SeleniumLearning.AbstractPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {//this is a constructor to catch the driver variable received from the child class
		// TODO Auto-generated constructor stub
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	 */
	public void WaitforElementToAppear(By Findby)
	{
		
		//By.cssSelector(".mb-3"))--this return type is By so above we are passing By Findby where Findby is the variable and By is the return type
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
		
	}
	
	public void WaitforWebElementToAppear(WebElement Findby)
	{
		
		//By.cssSelector(".mb-3"))--this return type is By so above we are passing By Findby where Findby is the variable and By is the return type
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Findby));
		
	}
	
	public void WaitforElementToDisappear(WebElement Findbyinv) throws InterruptedException
	{
		
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.invisibilityOf(Findbyinv));
		
		
	}
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	public void GoToCart() throws InterruptedException
	{
		Thread.sleep(1000);
		cart.click();
	}
	
	//myorders
	@FindBy(css="[routerlink*='myorders']")
	WebElement MyOrder;
	
	public void GotoOrder() throws InterruptedException
	{
		Thread.sleep(1000);
		MyOrder.click();
	}
	

}
