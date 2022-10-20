package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.RegisterPage;
import utils.TestContextSetup;

public class RegisterStepDefinition {
    TestContextSetup testContextSetup;
    RegisterPage registerPage;
    public RegisterStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        this.registerPage =testContextSetup.pageObjectManager.getRegisterPage();
    }

    @When("user successfully is able to register by required fields in nopStation")
    public void user_successfully_is_able_to_register_by_required_fields_in_nopstation()
    {
        registerPage.registerButtonClick();
        registerPage.firstNameInput();
        registerPage.lastNameInput();
        registerPage.emailInput();
        registerPage.usernameInput();
        registerPage.passwordInput();
        registerPage.confirmPasswordInput();
        registerPage.registerSubmitButtonClick();
      //  registerPage.validationSuccessfulMessage();

    }

    @And("Verify that user registered successfully")
    public void verify_that_user_registered_successfully(){

        String _validationMSG = registerPage.validationSuccessfulMessage();

        try {
            Assert.assertEquals("Your registration completed", _validationMSG);
            ExtentCucumberAdapter.addTestStepLog("User is able to register successfully");
        } catch (Exception e) {
            ExtentCucumberAdapter.addTestStepLog("User is unable to register successfully");
            Assert.fail("User is unable to register successfully");
        }

   }
}
