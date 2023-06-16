package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userPage {
    @FindBy(xpath = "//*[@onclick=\"openAddingUserSidebar()\"]") WebElement addUser;
    @FindBy(xpath = "//*[@onclick=\"sendEmailPopup()\"]") WebElement sendEmail;
    @FindBy(xpath = "//*[@data-id=\"fltrUserType\"]") WebElement roleDropdown;
    @FindBy(xpath = "//*[@id=\"fltrUserType\"]") WebElement selectroleDropdown ;
    @FindBy(xpath = "//*[@id=\"input-search-header\"]") WebElement searchUser;
    @FindBy(xpath = "//*[@src=\"/icons/logo2.png\"]") WebElement CQlogoheader;
    @FindBy(xpath = "//*[@class=\"page-title\"]") WebElement pageTitle;
    @FindBy (name="tbllist_length") WebElement usertableLength;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[2]") WebElement userName;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[3]") WebElement userrole;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[4]") WebElement userEmail;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[6]") WebElement userCreatedAt;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[7]") WebElement assignedInvites;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[7]") WebElement learnerActionButton;
    @FindBy(xpath = "//*[@id=\"tablebody\"]//tr//td[8]") WebElement MentorActionButton;
    @FindBy(xpath = "//*[@src=\"/icons/edit.png\"]") WebElement editUser;








}
