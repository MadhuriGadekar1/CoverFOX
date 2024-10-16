package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxaddressdetailsPage {
	//variables
@FindBy(xpath="(//input[@type='number'])[1]")private WebElement pinCodeField;
@FindBy(id="want-expert")private WebElement mobileNumberField;
@FindBy(className="next-btn")private WebElement continueButton;

//Variable initialization by using Constructor
public CoverFoxaddressdetailsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//use methode by action
public void enterPinCode(String pinCode)
{
	Reporter.log("Enter a pinCode",true);
	pinCodeField.sendKeys(pinCode);
}
public void enterMobileNumber(String mobNum)
{
	Reporter.log("Enter the mobile number...", true);
	mobileNumberField.sendKeys(mobNum);
	
}
public void ClickOnContinueButton()
{
	Reporter.log("Click on continue button.... ",true);
	continueButton.click();
}






}
