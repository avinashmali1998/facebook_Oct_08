package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenShot(WebDriver driver,String testID) throws IOException 
	{
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss");
		LocalDateTime now = LocalDateTime.now();
		
		 TakesScreenshot ts = (TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File("C:\\Users\\Avinash\\OneDrive\\Documents\\Selenium ScreenShots\\Test"+testID+"+"+dtf.format(now)+".png");
		 FileHandler.copy(src, dest);
		 
	}
	
	
//	public static String getDataFromExcelSheet(String sheet,int row , int cell) throws EncryptedDocumentException, IOException
//	{
//		String data = "";
//		String path = "abchd";
//		InputStream  file = new FileInputStream(path);
//		Workbook book = WorkbookFactory.create(file);
//		
//		try {
//			data = book.getSheet("").getRow(0).getCell(0).getStringCellValue();
//			
//		}
//		catch (IllegalStateException e) {
//			double value = book.getSheet("").getRow(0).getCell(0).getNumericCellValue();
//			data = Double.toString(value);
//		}
//		return data;
		
		
//	}
	
	
}
