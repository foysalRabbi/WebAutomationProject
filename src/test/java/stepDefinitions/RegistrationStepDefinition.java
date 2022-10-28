package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.pages.RegistrationPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationStepDefinition {

   private RegistrationPage registerPage = new RegistrationPage(DriverFactory.getDriver());
    Xls_Reader nopData = new Xls_Reader("src/test/resources/TestData/NopTestData.xlsx");
    String registerSheet = "Registration_Page";
    String verifyMessage = "NopVerify";
    @When("take input in all fields on the registration page")
    public void take_input_in_all_fields_on_the_registration_page()
    {
        String genderMale = nopData.getCellData(registerSheet, "GenderMale", 2).trim();
        String genderFemale = nopData.getCellData(registerSheet, "GenderFemale", 2).trim();
        String firstName = nopData.getCellData(registerSheet, "FirstName", 2).trim();
        String lastName = nopData.getCellData(registerSheet, "LastName", 2).trim();
        String dateOfBirthDay = nopData.getCellData(registerSheet, "DateOfBirthDay", 2).trim();
        String dateOfBirthMonth = nopData.getCellData(registerSheet, "DateOfBirthMonth", 2).trim();
        String dateOfBirthYear = nopData.getCellData(registerSheet, "DateOfBirthYear", 2).trim();
        String email = nopData.getCellData(registerSheet, "Email", 2).trim();
        String username = nopData.getCellData(registerSheet, "Username", 2).trim();
        String companyName = nopData.getCellData(registerSheet, "CompanyName", 2).trim();
        String newsletter = nopData.getCellData(registerSheet, "Newsletter", 2).trim();
        String password = nopData.getCellData(registerSheet, "Password", 2).trim();
        String confirmPassword = nopData.getCellData(registerSheet, "ConfirmPassword", 2).trim();

        registerPage.goToNopURL();
        registerPage.registerButtonClick();
        registerPage.genderMaleRadioBtn();
        registerPage.firstNameInput(firstName);
        registerPage.lastNameInput(lastName);
        registerPage.dateOfBrithDayInput(dateOfBirthDay);
        registerPage.dateOfBrithMonthInput(dateOfBirthMonth);
        registerPage.dateOfBirthYearInput(dateOfBirthYear);
        registerPage.emailInput(email);
        registerPage.usernameInput(username);
        registerPage.companyNameInput(companyName);
        registerPage.newsletterEnable(newsletter);
        registerPage.passwordInput(password);
        registerPage.confirmPasswordInput(confirmPassword);
        registerPage.registerSubmitButtonClick();
    }

    @And("Verify that user registered successfully")
    public void verify_that_user_registered_successfully(){
        String registerValidationMSG = nopData.getCellData(verifyMessage, "VerifyRegister", 2).trim();
        String _validationMSG = registerPage.validationSuccessfulMessage();

        try {
            Assert.assertEquals(registerValidationMSG, _validationMSG);
            ExtentCucumberAdapter.addTestStepLog("User is able to register successfully");
        } catch (Exception e) {
            ExtentCucumberAdapter.addTestStepLog("User is unable to register successfully");
            Assert.fail("User is unable to register successfully");
        }

    }
}
