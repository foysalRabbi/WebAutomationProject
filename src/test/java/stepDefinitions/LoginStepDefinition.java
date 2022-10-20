package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import utils.TestContextSetup;
import utils.Xls_Reader;

public class LoginStepDefinition {
    TestContextSetup testContextSetup;
    LoginPage loginPage;
    public LoginStepDefinition(TestContextSetup testContextSetup)
    {

        this.testContextSetup=testContextSetup;
        this.loginPage =testContextSetup.pageObjectManager.getLoginPage();
    }

    Xls_Reader nopData = new Xls_Reader("src/test/resources/TestData/NopTestData.xlsx");
    String loginCredentials = "Nop_Login";
    String searchProduct = "Search_Product";

    @Given("A user must visit at homepage through the desired URL")
    public void a_user_must_visit_at_homepage_through_the_desired_url()
    {
        loginPage.loginMenuClick();

    }
    @When("A user enters a valid username in username field")
    public void a_user_enters_a_valid_username_in_username_field()
    {
        String user_emailID = nopData.getCellData(loginCredentials, "EmailID", 2).trim();
        loginPage.usernameInput(user_emailID);
    }
    @And("A user enters a valid password in password field")
    public void a_user_enters_a_valid_password_in_password_field()
    {
        String user_Password = nopData.getCellData(loginCredentials, "Password", 2).trim();
        loginPage.passwordInput(user_Password);
    }
    @And("A user click on submit button")
    public void a_user_click_on_submit_button()
    {
        loginPage.loginButtonClick();
    }
    @Then("A user is able to view a redirect page")
    public void a_user_is_able_to_view_a_redirect_page() {
       String _validationLoginMSG = loginPage.validationLoginPage();
        try {
            Assert.assertEquals("Log out", _validationLoginMSG);
            ExtentCucumberAdapter.addTestStepLog("User is able to login successfully");
        } catch (Exception e) {
            ExtentCucumberAdapter.addTestStepLog("user is unable to login successfully");
            Assert.fail("User is unable to register successfully");
        }

    }
    @When("Take input a product in the search box")
    public void take_input_a_product_in_the_search_box() throws Throwable {
        String productName = nopData.getCellData(searchProduct, "Name", 2).trim();
        loginPage.searchInputBox(productName);

    }
    @And("Click search button")
    public void click_search_button() throws Throwable {
        loginPage.searchButtonClick();

    }
    @When("Click add to cart button in search page")
    public void click_add_to_cart_button_in_search_page() throws Throwable {

        loginPage.addToCartButtonClick();
    }

    @And("click add to cart button in details page")
    public void click_add_to_cart_button_in_details_page() throws Throwable {
        loginPage.addToCartForMiniShoppingCart();

    }

}
