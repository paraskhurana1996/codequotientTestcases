package pages;

import java.util.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import baseClass.readFiles;
public class questionPage extends readFiles {
	static public String list[];
	@FindBy (xpath="//*[@data-customtooltip=\"Add new question\"]") WebElement createQuestion;
	@FindBy (name="fltrQBy") WebElement questionDropdown;
	@FindBy (xpath="//*[@placeholder=\"Filters\"]") WebElement filterSearch;
	@FindBy (xpath ="//ul[@class=\"filtered-dropdown-menu-items\"] ") static public WebElement filterMenu;
	@FindBy (xpath ="//ul[@class=\"filtered-dropdown-menu-items\"] //li[contains(text(),'Question Type')]") WebElement filterQuesType;
	@FindBy (xpath="//ul[@class=\"filtered-dropdown-sub-menu-items px-2\"]//li[@class=\"filtered-sub-item\"]//label") WebElement typesQuestion;
	@FindBy (className="page-title") WebElement pageTitle;
	@FindBy (name="tbllist_length") WebElement tableLength;
	@FindBy (xpath="//*[@class=\"public\"]") WebElement publicFlag;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[3]") WebElement questionType;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[4]") WebElement testCases;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[5]") WebElement languages;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[6]") WebElement score;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[8]") WebElement updatedAt;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[9]") WebElement actionDots;
	@FindBy(className="navbar-brand") WebElement CQLogo;
	@FindBy(id="executeProgram") WebElement executeButton;
	@FindBy(id="nav-attempts-tab") WebElement attemptsList;
	@FindBy(xpath="//*[@class='failed']//p[2]") WebElement attemptResult;
	@FindBy(id ="saveBtn") public static WebElement saveButton;
	List<WebElement> typeList = driver.findElements(By.xpath("//ul[@class=\"filtered-dropdown-sub-menu-items px-2\"]//li[@class=\"filtered-sub-item\"]//label]"));
	Actions act =new Actions(driver);
	
	public questionPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
			public String validateQuestionPageTitle(){
				System.out.print(driver.getTitle());
				return driver.getTitle();
			}
			
			public boolean validateCQImage(){
				return CQLogo.isDisplayed();
			}
			
			public void questionMQAttempt() throws InterruptedException {
				driver.get(prop.getProperty("questionAttempt"));
				Thread.sleep(2000);
			}
			
			public String validateBlankMQResult() throws InterruptedException{
				
				executeButton.click();
				Thread.sleep(2000);
				attemptsList.click();
				Thread.sleep(2000);
				return attemptResult.getText();
				
			}
			
			public String[] questionTypeOrder() {
				
				int i=0;
				
				filterSearch.click();
			
				 for(WebElement qtData:typeList){
				list[i++]=qtData.getText();
			}
					return list;
				
			}
			
			
			
			
			
	
	
	
	
	
	
	
	
	
	
}
