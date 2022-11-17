package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {
  private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    Xls_Reader nopData = new Xls_Reader("src/test/resources/TestData/NopTestData.xlsx");
    String loginCredentials = "Nop_Login";
    @Given("A user must visit in Homepage")
    public void a_user_must_visit_in_homepage()
    {
       DriverFactory.getDriver().get("https://test450.nop-station.com/");
        loginPage.loginMenuClick();

    }

    @When("A user enters by valid username and password")
    public void a_user_enters_by_valid_username_and_password(){
        String user_emailID = nopData.getCellData(loginCredentials, "EmailID", 2).trim();
        String user_Password = nopData.getCellData(loginCredentials, "Password", 2).trim();
        loginPage.usernameInput(user_emailID);
        loginPage.passwordInput(user_Password);
        loginPage.loginButtonClick();
    }

    @Then("Verify that user logged in successfully")
    public void verify_that_user_logged_in_successfully() {
        String verifyLogin = nopData.getCellData(loginCredentials,"VerifyLogin",2).trim();
        String _validationLoginMSG = loginPage.validationLoginPage();
        try {
            Assert.assertEquals(verifyLogin, _validationLoginMSG);
            ExtentCucumberAdapter.addTestStepLog("User is able to login successfully");
        } catch (Exception e) {
            ExtentCucumberAdapter.addTestStepLog("user is unable to login successfully");
            Assert.fail("User is unable to register successfully");
        }
    }

}
