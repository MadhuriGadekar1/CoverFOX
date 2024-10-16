package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxmemberdetailsPage1 {
@FindBy(id="Age-You")private  WebElement ageDropDown;
@FindBy(className="next-btn")private WebElement NextButton;
//By using constructor to initialize variable
public CoverFoxmemberdetailsPage1(WebDriver driver)
{
	PageFactory.initElements(driver, this);
	
}
//use methode to handle dropdown
public void handleAgeDropDown(String age)
{
	Reporter.log("Handling age dropDown...", true);
	Select sel=new Select(ageDropDown);
	sel.selectByValue(age+"y");
}
public void clickOnNextButton()
{
	Reporter.log("click on next button...", true);
	NextButton.click();
}



}
