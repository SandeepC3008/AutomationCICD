package SeleniumLearning.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumLearning.AbstractPackage.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	//String FinalMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	@FindBy(css=".hero-primary")
	WebElement FinalMessage;
	
	
	public String Confirm()
	{
		String Text = FinalMessage.getText();
		System.out.println(Text);
		return Text;
	}

}
