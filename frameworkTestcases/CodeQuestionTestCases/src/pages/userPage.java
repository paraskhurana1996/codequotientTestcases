package pages;
import testCases.*;
import baseClass.readFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class userPage extends readFiles {
    @FindBy(xpath = "//*[@onclick=\"openAddingUserSidebar()\"]") static WebElement addUser;
    @FindBy(xpath = "//*[@onclick=\"sendEmailPopup()\"]") static WebElement sendEmail;
    @FindBy(xpath = "//*[@class=\"tag-editor\"]") static WebElement sendMailTagEditor;
    @FindBy(xpath = "//*[@data-id=\"fltrUserType\"]") static WebElement roleDropdown;
    @FindBy(xpath = "//*[@id=\"fltrUserType\"]") static WebElement selectroleDropdown ;
    @FindBy(xpath = "//*[@id=\"input-search-header\"]") static WebElement searchUser;
    @FindBy(xpath = "//*[@src=\"/icons/logo2.png\"]") static WebElement CQlogoheader;
    @FindBy(xpath = "//*[@class=\"page-title\"]") static WebElement pageTitle;
    @FindBy (name="tbllist_length") static WebElement usertableLength;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[2]") static WebElement userName;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[3]") static WebElement userrole;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[4]") static WebElement userEmail;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[6]") static WebElement userCreatedAt;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[7]") static WebElement assignedInvites;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[7]") static WebElement learnerActionButton;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[8]") static WebElement MentorActionButton;
    @FindBy(xpath = "//*[@src=\"/icons/edit.png\"]") static WebElement editUser;
    @FindBy(xpath = "//*[@id=\"alert-message\"]") static WebElement alert;
    @FindBy(xpath = "//*[@class=\"close close-add-modal-right-sidebar\"]") static List<WebElement> sideTabCloseButton;
    @FindBy(xpath = "//*[contains(@class,\"mt-2 modal-title\")]") static List<WebElement> sideTabHeading;
    public userPage(){ PageFactory.initElements(driver, this); 	}
    public String validateUserPageTitle(){
        return driver.getTitle();
    }
    public boolean validateCQImage(){
        return CQlogoheader.isDisplayed();
    }

    public static String openSendEmailTab() throws InterruptedException {
        sendEmail.click();
        Thread.sleep(1000);
        return sideTabHeading.get(0).getText();

    }

    public Boolean issue_3456() throws Exception {
        openSendEmailTab();
        Actions action = new Actions(driver);
        action.moveToElement(sendMailTagEditor).click().sendKeys("123").build().perform();
        sideTabCloseButton.get(0).click();
        Thread.sleep(1000);
        return alert.isDisplayed();

    }

    public void issue_3430(){

    }








}
