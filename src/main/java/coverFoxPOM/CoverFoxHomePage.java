package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
//variable declration webelement
	//WebElement name= driver.findElement(By.)
	@FindBy(xpath="//div[text()='Female']")private WebElement gender;
	
	//Constructor use by variable initialization
	public CoverFoxHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//method 
	
	public void ClickOnGenderButton()
	{
		Reporter.log("Click on gender button...",true);
		gender.click();
	}
	

}
