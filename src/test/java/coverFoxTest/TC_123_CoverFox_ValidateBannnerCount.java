package coverFoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFoxBase.Base;
import coverFoxPOM.CoverFoxHealthPlanPage;
import coverFoxPOM.CoverFoxResultPage;
import coverFoxPOM.CoverFoxaddressdetailsPage;
import coverFoxPOM.CoverFoxmemberdetailsPage1;
import coverFoxUtility.Utility;
import coverFoxPOM.*;


public class TC_123_CoverFox_ValidateBannnerCount extends Base {
	
	CoverFoxHomePage homePage;
	CoverFoxHealthPlanPage healthPlanPage;
	//CoverFoxmemberdetailsPage1 memberdetailsPage; 
	CoverFoxmemberdetailsPage1 memberdetailsPage;
	CoverFoxaddressdetailsPage addressdetailPage;
	CoverFoxResultPage resultPage;
	//String excelPath="C:\\Users\\Madhuri Dilwale\\eclipse-workspace\\Automation8_June_Selenium\\TestData\\madhuri.xlsx";
	String excelPath=System.getProperty("user.dir")+"\\TestData\\madhuri.xlsx";
	String sheetName="Sheet3";
	public static Logger logger; 
	
	
	//Open browser/app
	

	  
    @BeforeClass
    public void openApplication() throws IOException
    {
    	launchBrowser();
    	logger=Logger.getLogger("Cover_Fox");
    	PropertyConfigurator.configure("log4j.properties");
    	logger.info("Launching browser");		
    	
    	
    }
	//gender Selection, next button click,  Age selection , Dial pincode and mobile number click on  next
    @BeforeMethod
    public void enterDetail()throws IOException,EncryptedDocumentException,InterruptedException
    {
    	homePage=new CoverFoxHomePage(driver);
    	healthPlanPage=new CoverFoxHealthPlanPage(driver);
        memberdetailsPage=new CoverFoxmemberdetailsPage1(driver);
    	addressdetailPage=new CoverFoxaddressdetailsPage (driver);
    	resultPage=new CoverFoxResultPage(driver); 
    	
    	homePage.ClickOnGenderButton();
    	Thread.sleep(1000);
    	logger.info("Clicking on Gender button ");
    	
    	healthPlanPage.ClickOnNextButton();
    	logger.info("Clicking on Next button ");
    	Thread.sleep(1000);
    	logger.warn("Select valid AgeGroup");
    	memberdetailsPage.handleAgeDropDown(Utility.readDataFromExcel(excelPath, sheetName, 0, 0));
    	logger.info("Handling dropdown ");
    	memberdetailsPage.clickOnNextButton();
    	logger.info("Clicking on Next button ");
 
    	Thread.sleep(3000);
    	logger.warn("Enter valid PinCode");
    	addressdetailPage.enterPinCode(Utility.readDataFromExcel(excelPath, sheetName, 0, 1));
    	logger.info("Enter pinCode ");
    	logger.warn("Enter valid mobile number");
    	addressdetailPage.enterMobileNumber(Utility.readDataFromExcel(excelPath, sheetName, 0, 2));
    	
    	logger.info("Enter mobile no ");
    	logger.error("Incorrect information");
    	addressdetailPage.ClickOnContinueButton();
    	logger.info("Clicking on Continue button ");
    	Thread.sleep(3000);
    }


	
	
  @Test
  public void validatePolicyCount() {
	 int textCount = resultPage.getCountFromText(); 
	 int bannerCount=resultPage.getCountFromBanner();
	 
	 Assert.assertEquals( textCount ,bannerCount,"textCount is not matching with Banner Count ,TC is Failed" );
	 // Assert.fail();
	  
  }
  
  //logout
  @AfterClass
  public void closeApplication()
  {
	  logger.info("Closing Application");
	  closeBrowser();
  }
  
  //close browser/App is close
}
