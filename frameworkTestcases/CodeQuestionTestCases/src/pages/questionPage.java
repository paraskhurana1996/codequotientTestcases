package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.readFiles;
public class questionPage extends readFiles {

	@FindBy (xpath="//*[@data-customtooltip=\"Add new question\"]") WebElement createQuestion;
	@FindBy (name="fltrQBy") WebElement questionDropdown;
	@FindBy (className="filtered-search-box") WebElement filterSearch;
	@FindBy (className="page-title") WebElement pageTitle;
	@FindBy (name="tbllist_length") WebElement tableLength;
	@FindBy (xpath="//*[@class=\"public\"]") WebElement publicFlag;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[3]") WebElement questionType;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[4]") WebElement testCases;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[5]") WebElement languages;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[6]") WebElement score;
	@FindBy(xpath="//*[@id=\"tablebody\"]/tr/td[8]") WebElement updatedAt;
	
	
	
	
	
	
	
}
