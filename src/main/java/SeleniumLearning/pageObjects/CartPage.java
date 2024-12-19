package SeleniumLearning.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumLearning.AbstractPackage.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//List <WebElement> CartProd = driver.findElements(By.cssSelector(".cartSection h3"));
	
	@FindBy(css=".cartSection h3")
	List<WebElement> CartProd;
	//driver.findElement(By.cssSelector("li[class='totalRow'] button[type='button']")).click();
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement country;
	
	//driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
	@FindBy(css="input[placeholder='Select Country']")
	WebElement countrydropdown;
	String Location = "India";
	//By.cssSelector(".ta-results")
	By LocationDropdown = By.cssSelector(".ta-results");
	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement RequiredLoc;
	//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement Submit;
	
	//Boolean Result = CartProd.stream().anyMatch(finalprod->finalprod.getText().equalsIgnoreCase(Prodname));
	public Boolean VerifyProductDisplay(String Prodname)
	{
		Boolean Result = CartProd.stream().anyMatch(finalprod->finalprod.getText().equalsIgnoreCase(Prodname));
		return Result;
	}
	
	public void countryvalue()
	{
		country.click();
		countrydropdown.sendKeys(Location);
		WaitforElementToAppear(LocationDropdown);
		RequiredLoc.click();
		Submit.click();
		
		
		
	}
	
	
	

}
