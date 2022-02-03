package pagesTest;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class SignUpTestBase extends TestBase {

    String firstName, lastName, email, emailConfirmation, password, dayOfBirth,
            monthOfBirth, yearOfBirth, gender, errorMessage;
    SignUpPage signUpPage = new SignUpPage(driver);
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);


    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testSignUpWithInvalidFirstUserName(String sheetName, int userNumber) {

        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserData(firstName, lastName, email, emailConfirmation, password, dayOfBirth, monthOfBirth, yearOfBirth, gender)
                .clickOnSignUpBtn();
        Assert.assertTrue(signUpPage.isUserNameErrorMessageDisplayed());

    }

    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testSignUpWithInvalidLastUserName(String sheetName, int userNumber) {
        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserData(firstName, lastName, email, emailConfirmation, password, dayOfBirth, monthOfBirth, yearOfBirth, gender)
                .clickOnSignUpBtn();
        Assert.assertTrue(signUpPage.isUserNameErrorMessageDisplayed());

    }

    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testSignUpWithInvalidUserDateOfBirth(String sheetName, int userNumber) {
        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserDataWithOutDateOfBirth(firstName, lastName, email, emailConfirmation, password, gender)
                .clickOnSignUpBtn();
        Assert.assertEquals(signUpPage.getBirthDateErrorMessage(), errorMessage);

    }

    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testSignUpWithEmailsDoseNotMatch(String sheetName, int userNumber) {
        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserData(firstName, lastName, email, emailConfirmation, password, dayOfBirth, monthOfBirth, yearOfBirth, gender)
                .clickOnSignUpBtn();
//        Assert.assertEquals(email,emailConfirmation);
        System.out.println(errorMessage);
        Assert.assertTrue(signUpPage.isOnOfErrorMessagesListDisplayed(errorMessage));

    }

    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testSignUpWithNoGender(String sheetName, int userNumber) {
        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserData(firstName, lastName, email, emailConfirmation, password, dayOfBirth, monthOfBirth, yearOfBirth, gender)
                .clickOnSignUpBtn();
        System.out.println(errorMessage);
        Assert.assertTrue(signUpPage.isOnOfErrorMessagesListDisplayed(errorMessage));

    }

    @Test
    @Parameters({"sheetName", "userNumber"})
    public void testUserSignUpSuccessfully(String sheetName, int userNumber) {

        getDataOfUserByIndex(sheetName, userNumber);
        signUpPage = loginPage.clickOnSignUpBtn();
        signUpPage.fillSignUpUserData(firstName, lastName, email, emailConfirmation, password, dayOfBirth, monthOfBirth, yearOfBirth, gender)
                .clickOnSignUpBtn();
        Assert.assertTrue(homePage.isFacebookIconDisplayed());
        homePage.clickOnAccountIcon().clickOnLogOutBtn();
        Assert.assertTrue(loginPage.isLoginBtnDisplayed());
    }


    private void getDataOfUserByIndex(String sheetName, int userNumber) {
        spreadSheet.switchToSheet(sheetName);
        firstName = spreadSheet.getCellData("FirstName", userNumber);
        lastName = spreadSheet.getCellData("LastName", userNumber);
        email = spreadSheet.getCellData("Email", userNumber);
        emailConfirmation = spreadSheet.getCellData("EmailConfirmation", userNumber);
        password = spreadSheet.getCellData("Password", userNumber);
        dayOfBirth = spreadSheet.getCellData("Day", userNumber);
        monthOfBirth = spreadSheet.getCellData("Month", userNumber);
        yearOfBirth = spreadSheet.getCellData("Year", userNumber);
        gender = spreadSheet.getCellData("Gender", userNumber);
        errorMessage = spreadSheet.getCellData("Error", userNumber);

    }
}
