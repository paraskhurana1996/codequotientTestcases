package linkFetch;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class linksFromSite {
	 public static void main(String[] args) throws InterruptedException, IOException{
		 try {
		 WebDriver driver = new ChromeDriver();
		// String fileName= "/src/main/configs/links.properties";
		 XSSFWorkbook wB= new XSSFWorkbook();
		 XSSFSheet sheet = wB.createSheet("LINKS");
		

		String url="https://supercoders.tech/supercoders-program";
			 driver.manage().window().maximize();
			driver.get(url); 
			 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			 String href="codequotient";
			 //Traversing through the list and printing its text along with link address
			 int i=0;
			 for(WebElement link:allLinks){
				 try {
				 if(link.getAttribute("href").contains(href)) {
					XSSFRow rHead=sheet.createRow(i);
					 i++;
					 rHead.createCell(0).setCellValue(link.getText());
					 rHead.createCell(1).setCellValue(link.getAttribute("href"));
					 rHead.createCell(2).setCellValue(link.getAttribute("href").contains("codequotient"));
					 
					 System.out.println(link.getText() + " - " +link.getAttribute("href")+" - "+ link.getAttribute("href").contains("codequotient"));
					 
				 }
				 } catch (Exception e)   
				 {  
					 e.printStackTrace();  
					 }  
			 }
			 FileOutputStream fOut=new FileOutputStream(System.getProperty("user.dir")+"/src/main/configs/links.xlsx");
			 wB.write(fOut);
			 fOut.close();  
			
			 wB.close();  
			//prints the message on the console  
			 System.out.println("Excel file has been generated successfully.");  
			 }   
			 catch (Exception e)   
			 {  
			 e.printStackTrace();  
			 }  
			 }  
			 }  