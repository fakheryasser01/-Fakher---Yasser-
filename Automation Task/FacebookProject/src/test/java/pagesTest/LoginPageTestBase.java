package pagesTest;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTestBase extends TestBase {

    private String email, password;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ForgotPassword forgotPassword = new ForgotPassword(driver);


    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testUserSignInWithInvalidPassword(String sheetName, int userNumber) {
        getLoginUsersDataByIndex(sheetName, userNumber);
        loginPage.userLogin(email, password);
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(forgotPassword.isIncorrectPasswordMessageDisplayed());
    }


    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testUserSignInWithInvalidEmail(String sheetName, int userNumber) {
        getLoginUsersDataByIndex(sheetName, userNumber);
        loginPage.userLogin(email, password);
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(homePage.isFacebookIconDisplayed());

//        Assert.assertTrue(loginPage.isIncorrectEmailMessageDisplayed());


    }


    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testUserSignInWithInvalidEmailAndPassword(String sheetName, int userNumber) {
        getLoginUsersDataByIndex(sheetName, userNumber);
        loginPage.userLogin(email, password);
        loginPage.clickOnLoginBtn();
        Assert.assertFalse(forgotPassword.isIncorrectPasswordMessageDisplayed());

//        Assert.assertTrue(forgotPassword.isIncorrectPasswordMessageDisplayed());
    }


    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testUserSignInSuccessfully(String sheetName, int userNumber) {
        getLoginUsersDataByIndex(sheetName, userNumber);
        loginPage.userLogin(email, password);
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(homePage.isFacebookIconDisplayed());
        homePage.clickOnAccountIcon().clickOnLogOutBtn();
        Assert.assertTrue(loginPage.isStopUsingFacebookIconDisplayed());

    }


    private void getLoginUsersDataByIndex(String sheetName, int userNumber) {
        spreadSheet.switchToSheet(sheetName);
        email = spreadSheet.getCellData("Email", userNumber);
        password = spreadSheet.getCellData("Password", userNumber);

    }
}
