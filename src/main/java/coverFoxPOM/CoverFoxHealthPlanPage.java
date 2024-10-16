package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPlanPage {
  //Variable Declration
	@FindBy(className="next-btn")private WebElement nextButton;
	
	//Constructor use for variable initialization
	
     public	CoverFoxHealthPlanPage( WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public void ClickOnNextButton()
     {
    	 Reporter.log("click on next button...", true);
    	nextButton.click(); 
     }
	
}
