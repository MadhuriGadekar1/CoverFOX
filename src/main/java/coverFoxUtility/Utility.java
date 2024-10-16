package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
//All code from Commenly use method
	public static void takeScreenshot(WebDriver driver, String filename) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		// File Dest=new File("C:\\Users\\Madhuri Dilwale\\Desktop\\manualTesting\\" +
		// filename + timeStamp + ".png");
		File Dest = new File(System.getProperty("user.dir")+"\\Screenshot1\\"
				+ filename + timeStamp + ".png");
		FileHandler.copy(source, Dest);

	}

	public static String readDataFromExcel(String excelPath, String SheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException

	{
		FileInputStream myFile = new FileInputStream(excelPath);
		String value = WorkbookFactory.create(myFile).getSheet(SheetName).getRow(rowNum).getCell(cellNum)
				.getStringCellValue();
		return value;
	}
	public static String readDataFromPropertyFile(String key) throws IOException
	{
		Properties properties=new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"//configue.properties");
		properties.load(myfile);
		String value = properties.getProperty(key);
		return value;
		
	}

}
