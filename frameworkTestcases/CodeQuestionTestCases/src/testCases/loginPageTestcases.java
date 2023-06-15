package testCases;
import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import baseClass.screenShort;
import pages.loginPage;

public class loginPageTestcases extends loginPage{
	
	loginPage loginPage;
	String path;
	@BeforeSuite
	public void setUp(){
		initialization();
		loginPage = new loginPage();	
	}
	
	@BeforeMethod
	public void clearText() {
		loginPage.clearData();
	}
	
	@AfterSuite
	public void QuestionPage() throws InterruptedException{
		loginPage.questionPage();
	}
	
	public loginPageTestcases() {
		super();
	}
	
	
	
	static String title ;
	@Test(priority=0)
	public void checkPageStatus() throws Exception{
		int status = loginPage.vlaidatePageStatus();
		try {
			Assert.assertEquals(status,"200");
		}catch(AssertionError e){
			screenShort.path="checkPageStatus"+status;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws Exception{
		 title = loginPage.validateLoginPageTitle();
		
		try {
			Assert.assertEquals(title,"Login | CodeQuotient");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() throws Exception{
		boolean flag = loginPage.validateCQImage();
		
		try {
			Assert.assertTrue(flag);
		}catch(AssertionError e){
			screenShort.path="missingLogo";
			   screenShort.captureScreenMethod(); fail();
			}
	}

	
	@Test(priority=3)
	public void emptyEmail() throws Exception{
		 title = loginPage.validateEmptyEmail();
		try {
			Assert.assertEquals(title,"Please enter email address.");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=4)
	public void emptyPassword() throws Exception{
		 title = loginPage.validateEmptyPassword();
		try {
			Assert.assertEquals(title,"Please enter password.");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=5)
	public void incorrectEmail() throws Exception{
		 title = loginPage.validateEmail();
		try {
			Assert.assertEquals(title,"Given credentials are not valid.");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	
	@Test(priority=6)
	public void incorrectPassword() throws Exception{ 
		title = loginPage.validatePassword();
		try {
			Assert.assertEquals(title,"Given credentials are not valid.");
		}catch(AssertionError e){
			screenShort.path=title;
			   screenShort.captureScreenMethod(); fail();
			}
	}
	@Test(priority=7)
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
	
	}
