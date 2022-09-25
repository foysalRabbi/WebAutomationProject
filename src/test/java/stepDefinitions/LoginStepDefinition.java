package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LoginStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage;
    public LoginStepDefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.loginPage =testContextSetup.pageObjectManager.getLoginPage();
    }

    @Given("A user must visit at homepage through the desired URL")
    public void a_user_must_visit_at_homepage_through_the_desired_url()
    {
        loginPage.loginMenuClick();

    }
    @When("A user enters a valid username in username field")
    public void a_user_enters_a_valid_username_in_username_field()
    {
        loginPage.usernameInput();
    }
    @And("A user enters a valid password in password field")
    public void a_user_enters_a_valid_password_in_password_field()
    {
        loginPage.passwordInput();
    }
    @And("A user click on submit button")
    public void a_user_click_on_submit_button()
    {
        loginPage.loginButtonClick();
    }
    @Then("A user is able to view a redirect page")
    public void a_user_is_able_to_view_a_redirect_page() {
        loginPage.validationLoginPage();

    }

}
