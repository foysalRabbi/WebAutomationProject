package stepDefinitions;

import io.cucumber.java.en.When;
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
        registerPage.validationSuccessfulMessage();

    }
}
