package baseClass;
import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class screenShort extends readFiles{
	public static String path; 
	public static void captureScreenMethod() throws Exception{
	
		
		LocalDateTime now = LocalDateTime.now();   
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+prop.getProperty("screenShort")+path+".png"));
		}
	}
	