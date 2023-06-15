package pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.GetHttpResponse;
import baseClass.readFiles;


public class loginPage extends readFiles{
	
	@FindBy(name="email") WebElement email;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(name="btnSubmit") WebElement SubmitButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CQLogo;
	
	@FindBy(id="alert-message") WebElement Alert;
	
	//@FindBy(id="alert-message") WebElement Password;

	static String message;
	
	public loginPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
		public int vlaidatePageStatus() throws IOException {
			String path = driver.getCurrentUrl();
			return GetHttpResponse.httpStatus(path);
			
		}
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCQImage(){
			return CQLogo.isDisplayed();
		}
		
		public String validateEmptyEmail() {
			password.sendKeys(prop.getProperty("password"));
			SubmitButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 message = Alert.getText();
			return message;
			
		}
		
		public String validateEmptyPassword() {
			email.sendKeys(prop.getProperty("email"));
			SubmitButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 message = Alert.getText();
			return message;
			
		}
		public String validateEmail() {
			email.sendKeys("h"+prop.getProperty("email"));
			password.sendKeys(prop.getProperty("password"));
			SubmitButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 message = Alert.getText();
			return message;
		}
		public String validatePassword() {
			email.sendKeys(prop.getProperty("email"));
			password.sendKeys("h"+prop.getProperty("password"));
			SubmitButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			 message = Alert.getText();
			return message;
		}
		
		public void clearData() {
			email.clear();
			password.clear();
		}
	

		public String validateCredentials( String emailID,String userPassword ) {
			email.clear();
			password.clear();
			email.sendKeys(emailID);
			password.sendKeys(userPassword);
			SubmitButton.click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			return driver.getCurrentUrl();
		}
		
		public void questionPage() throws InterruptedException {
			driver.get(prop.getProperty("questionEdit"));
			Thread.sleep(2000);
			
		}
		public void questionMQAttempt() throws InterruptedException {
			driver.get(prop.getProperty("questionAttempt"));
			Thread.sleep(2000);
		}
		
		public void logoutUser() {
			driver.get(prop.getProperty("logoutURL"));
		}
		
}

