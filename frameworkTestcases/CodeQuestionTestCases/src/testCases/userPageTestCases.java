package testCases;

import baseClass.screenShort;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.loginPage;
import pages.userPage;

import static org.testng.Assert.fail;

public class userPageTestCases extends userPage {
    userPage userPage;
    @BeforeSuite
    public void setup(){
        initialization();
        loginPage loginPage=new loginPage();
        loginPage.validateCredentials();
        userPage = new userPage();
        driver.get(prop.getProperty("userPageURL"));
    }

    @Test(priority=1)
    public void userPageTitleTest() throws Exception{
        String title = validateUserPageTitle();

        try {
            Assert.assertEquals(title,"User | CodeQuotient");
        }catch(AssertionError e){
            screenShort.path="wrong-page";
            screenShort.captureScreenMethod(); fail();
        }
    }

    @Test(priority=2)
    public void crmLogoImageTest() throws Exception{
        boolean flag = validateCQImage();

        try {
            Assert.assertTrue(flag);
        }catch(AssertionError e){
            screenShort.path="missingLogo";
            screenShort.captureScreenMethod(); fail();
        }
    }

    @Test
    public static void openSendEmailTabTest() throws Exception {
        try {
            Assert.assertEquals(openSendEmailTab(),prop.getProperty("sendmailheading"));
        }catch(AssertionError e){
            screenShort.path="sendmailtabnotopen";
            screenShort.captureScreenMethod(); fail();
        }

    }

    @Test
    public void issue_3456Test() throws Exception {
        try {Thread.sleep(1000);
            Assert.assertFalse(issue_3456());
        }catch(AssertionError e){
            screenShort.path="issue_3465";
            screenShort.captureScreenMethod(); fail();
        }

    }

    @Test
    public void issue_3430Test(){

    }

}
