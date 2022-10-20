package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;
import utils.Xls_Reader;

public class CheckoutStepDefinition {
    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;
    public CheckoutStepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        this.checkoutPage =testContextSetup.pageObjectManager.getCheckoutPage();
    }

    Xls_Reader nopData = new Xls_Reader("src/test/resources/TestData/NopTestData.xlsx");
    String checkout ="Checkout_Billing_Address";

    @When("Click on checkout button in my cart page")
    public void click_on_checkout_button_in_my_cart_page() throws Throwable {
        checkoutPage.miniShoppingCart();
       // checkoutPage.gotoCart();
        checkoutPage.termsConditions();
        checkoutPage.checkoutButtonClick();
    }

    @Then("Click continue button at customer's delivery section in checkout page")
    public void click_continue_button_at_customers_delivery_section_in_checkout_page() throws Throwable {
        String firstName = nopData.getCellData(checkout, "FirstName", 2).trim();
        String lastName = nopData.getCellData(checkout, "LastName", 2).trim();
        String email = nopData.getCellData(checkout, "Email", 2).trim();
        String companyName = nopData.getCellData(checkout, "CompanyName", 2).trim();
        String countryName = nopData.getCellData(checkout, "CountryId", 2).trim();
        String stateName = nopData.getCellData(checkout, "State", 2).trim();
        String city = nopData.getCellData(checkout, "City", 2).trim();
        String addressOne = nopData.getCellData(checkout, "AddressOne", 2).trim();
        String addressTwo = nopData.getCellData(checkout, "AddressTwo", 2).trim();
        String zipCode = nopData.getCellData(checkout, "ZipCode", 2).trim();
        String _phoneNumber = nopData.getCellData(checkout, "PhoneNumber", 2).trim();
        String _faxNumber = nopData.getCellData(checkout, "FaxNumber", 2).trim();



        checkoutPage.takeInputBillingAdd("New Address");
        checkoutPage.firstName(firstName);
        checkoutPage.lastName(lastName);
        checkoutPage.emailAddress(email);
        checkoutPage.companyName(companyName);
        checkoutPage.countrySelect(countryName);
        checkoutPage.stateSelect(stateName);
        checkoutPage.cityName(city);
        checkoutPage.firstAddress(addressOne);
        checkoutPage.secondAddress(addressTwo);
        checkoutPage.zipCode(zipCode);
        checkoutPage.phoneNumber(_phoneNumber);
       // checkoutPage.faxNumber(_faxNumber);
        checkoutPage.customerAddressContinueButton();
    }

    @And("Click continue button at shipping method section in checkout page")
    public void click_continue_button_at_shipping_method_section_in_checkout_page() throws Throwable {
      //  checkoutPage.groundRadioButton();
        checkoutPage.shippingMethodContinueButton();

    }

    @And("Click continue button at payment method section in checkout page")
    public void click_continue_button_at_payment_method_section_in_checkout_page() throws Throwable {
        checkoutPage.moneyOrderButton();
        checkoutPage.paymentMethodContinueButton();

    }

    @And("Click continue button at confirm order section in checkout page")
    public void click_continue_button_at_confirm_order_section_in_checkout_page() throws Throwable {
        checkoutPage.paymentInformationContinueButton();
    }

    @And("click confirm button at confirm order section in checkout page")
    public void click_confirm_button_at_confirm_order_section_in_checkout_page() throws Throwable {
        checkoutPage.confirmOrderButton();

    }
    @Then("^Verify that my order placed successfully$")
    public void verify_that_my_order_placed_successfully() throws Throwable {
        checkoutPage.confirmOrderSuccessfulPage();
    }

}
