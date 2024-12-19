package SeleniumLearning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumLearning.AbstractPackage.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;//here we are initiliasing the driver but still drive doesnt have any idea
	//si we need to create a constructor
	
	public LandingPage(WebDriver driver)
	{
		super(driver);//this is used to send driver variable to the parent class from child class
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(id="userEmail")
	WebElement Useremail;
	//this above 2 line is used to write the below code 
	//WebElement email = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	//the below is for the error message for wrong password
	@FindBy(css="[class*='flyInOut']")
	WebElement Error;
	
	public void Goto(String url)
	{
		driver.get(url);
	}
	
	
	public void loginApplication(String email, String password )
	{
		Useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
	}
	
	public String GetErrorMessage()
	{
		WaitforWebElementToAppear(Error);
		return Error.getText();
		
	}
	
	
	
	
	

}
