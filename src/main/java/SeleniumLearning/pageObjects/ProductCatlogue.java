package SeleniumLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumLearning.AbstractPackage.AbstractComponents;

public class ProductCatlogue extends AbstractComponents {
	WebDriver driver;//here we are initiliasing the driver but still drive doesnt have any idea
	//si we need to create a constructor
	
	public ProductCatlogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//List<WebElement> Items=driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> items;
	By Productsby= By.cssSelector(".mb-3");
	
	public List<WebElement> getProductList()
	{
		WaitforElementToAppear(Productsby);
		return items;
	}
	
	public WebElement GetProductname(String Prodname)
	{
		WebElement Prod =  getProductList().stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(Prodname)).findFirst().orElse(null);
		Prod.findElement(By.cssSelector(".card-body button.w-10")).click();
		return Prod;
		/*
		 * we have used getProductList() instead of items because both are same items is the return variable
		 * and getProductList() is the method name we can use the method name also
		 */
	}
	
	By addcart = By.cssSelector(".card-body button.w-10");
	By toastmessage = By.id("toast-container");
	By Loadicon = By.cssSelector(".ng-animating");
	@FindBy(css=".ng-animating")
	WebElement Findbyinv;
	
	public void AddtoCart(String Prodname) throws InterruptedException
	{
		WebElement Prod = GetProductname(Prodname);
		
		WaitforElementToAppear(toastmessage);
		WaitforElementToAppear(Loadicon);
		WaitforElementToDisappear(Findbyinv);
		Prod.findElement(addcart).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
