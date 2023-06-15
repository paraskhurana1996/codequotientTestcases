package testCases;

import static org.testng.Assert.fail;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import baseClass.screenShort;
import pages.*;

public class questionPageTestcases extends loginPage{
	
	questionPage questionPage;
	loginPage loginPage;
	static String path ;
	
	@BeforeSuite
	public void setUp() {
		initialization();
		loginPage = new loginPage();
		questionPage = new questionPage();
	}
	
	public questionPageTestcases() {
		super();
	}
	
	static String title ;
	
	
	@Test(priority=6)
	public void checkPageStatus() throws Exception{
		int status = loginPage.vlaidatePageStatus();
		System.out.println(status);
		try {
			Assert.assertEquals(status,200);
		}catch(AssertionError e){
			screenShort.path="checkPageStatus"+status;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=5)
	public void loginPageTitleTest() throws Exception{
		 title = questionPage.validateQuestionPageTitle();
		
		try {
			Assert.assertEquals(title,"AAC | CodeQuotient");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	@Test(priority=1)
	public void correctCredentials() throws Exception{ 
		String emailID = prop.getProperty("email");
		String userPassword = prop.getProperty("password");
		title = loginPage.validateCredentials(emailID,userPassword);
		try {
				Assert.assertEquals(title,prop.getProperty("defaultRoute"));
				
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	@Test(priority=3)
	public void crmLogoImageTest() throws Exception{
		boolean flag = questionPage.validateCQImage();
		
		try {
			Assert.assertTrue(flag);
		}catch(AssertionError e){
			screenShort.path="missingLogo";
			   screenShort.captureScreenMethod(); fail();
			}
	}
	@Test (priority=4)
	public void openAttemptLink(){
		try {
			questionPage.questionMQAttempt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	
	@Test (priority=7)
	public void issue_3322() throws Exception {
		
		
		title = questionPage.validateBlankMQResult();
		System.out.println(title);
			
			try {
				if(title.contains("2 / 5")) {
					Assert.assertTrue(true);
				}
			}catch(AssertionError e){
				screenShort.path="IncorrectResult";
				   screenShort.captureScreenMethod(); fail();
				}
		}
	
	@Test (priority=8)
	public void issue_3458() throws Exception {
		loginPage.logoutUser();
		driver.get(prop.getProperty("url"));
		String emailID = prop.getProperty("orgEmail");
		String userPassword = prop.getProperty("password");
		title = loginPage.validateCredentials(emailID,userPassword);
		driver.get(prop.getProperty("otherQuestionEdit"));
		Thread.sleep(2000);
		try {
	       pages.questionPage.saveButton.isDisplayed();
	       screenShort.captureScreenMethod(); 
	       Assert.fail();
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	       Assert.assertTrue(true);
	    }
	}
	@Test (priority=9)
	public void issue_3921() {
		driver.get(prop.getProperty("questionList"));
		System.out.println(questionPage.questionTypeOrder());
		
		
	}
}
