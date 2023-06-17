import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Links2{

    static public void main(String[] args) throws InterruptedException, IOException {
        WebDriver web = new ChromeDriver();
        int itr,rc=0,dcount;

        //login
        web.get("https://codequotient.com/login");
        web.manage().window().maximize();
        web.findElement(By.xpath("//input[@name='email']") ).sendKeys("gurharneet.singh@codequotient.com");
        web.findElement(By.id("password")).sendKeys("Gurneet@08");
        web.findElement(By.id("btnSubmit")).click();

        //read excel file
        FileInputStream IFstream = new FileInputStream("C:\\Users\\Nokia\\Documents\\ID.xlsx");             // input file
        XSSFWorkbook oexcl = new XSSFWorkbook(IFstream);
        XSSFSheet Sheet = oexcl.getSheetAt(0);
        int nrowcnt = Sheet.getLastRowNum();

        //new file
        FileOutputStream odfstram = new FileOutputStream("C:\\Users\\Nokia\\Documents\\Ques.xlsx");            // output file
        XSSFWorkbook odexcl = new XSSFWorkbook();
        XSSFSheet odsheet = odexcl.createSheet("Sheet1");

        for(int k=0;k<=nrowcnt;k++) {

            String ID = String.valueOf(Sheet.getRow(k).getCell(0));
            web.get("https://test.codequotient.com/quest/add/" + ID);
            XSSFRow orow = odsheet.createRow(rc++);
            int ccount =0;
            orow.createCell(ccount++).setCellValue(ID);
            if(Objects.equals(web.getCurrentUrl(), "https://test.codequotient.com/quest/add/" + ID)){
            String title = web.findElement(By.xpath("//*[@name=\"txtQuesTitle\"]")).getAttribute("value");
            String score = web.findElement(By.xpath("//*[@name=\"score\"]")).getAttribute("value");
            List<WebElement> key = web.findElements(By.xpath("//*[@class=\"tag-editor ui-sortable\"]//div[2]"));
            String type = web.findElement(By.xpath("//*[@data-id=\"type\"]")).getText();
            String des = web.findElement(By.xpath("//*[@id=\"editorQuil\"]/div[1]")).getText();

            // write in excel

            orow.createCell(ccount++).setCellValue(title);
            orow.createCell(ccount++).setCellValue(type);
            orow.createCell(ccount++).setCellValue(score);
            orow.createCell(ccount++).setCellValue("https://test.codequotient.com/quest/preview/"+ID);
            orow.createCell(ccount++).setCellValue(des);
            for (WebElement webElement : key) orow.createCell(ccount++).setCellValue(webElement.getText());

        }
            else{

                orow.createCell(1).setCellValue("Locked question");
            }

            }
        odexcl.write(odfstram);
        odfstram.close();
        web.close();




    }

}
