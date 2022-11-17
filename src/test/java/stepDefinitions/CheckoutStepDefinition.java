package stepDefinitions;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.pages.CheckoutPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Xls_Reader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutStepDefinition {

   private CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
    Xls_Reader nopData = new Xls_Reader("src/test/resources/TestData/NopTestData.xlsx");
    String checkout ="Checkout_Billing_Address";
    String searchProduct = "Search_Product";
    String allVerification = "NopVerify";

    @When("Take input a product in the search box")
    public void take_input_a_product_in_the_search_box() throws Throwable {
        String productName = nopData.getCellData(searchProduct, "Name", 2).trim();
        checkoutPage.searchInputBox(productName);

    }
    @And("Click search button")
    public void click_search_button() throws Throwable {
        checkoutPage.searchButtonClick();

    }
    @When("Click add to cart button in search page")
    public void click_add_to_cart_button_in_search_page() throws Throwable {
        checkoutPage.addToCartButtonClick();
    }
    @And("Click add to cart button in details page")
    public void click_add_to_cart_button_in_details_page() throws Throwable {
        String numberOfProduct = nopData.getCellData(searchProduct, "NumberOfProduct", 2).trim();
        checkoutPage.detailsPageScrollView();
        checkoutPage.productInput(numberOfProduct);
        checkoutPage.productAddToCartButtonClick();
        checkoutPage.scrollToTop();
    }
    @Then("Verify that products added to mini shopping cart successfully")
    public void verify_that_products_added_to_mini_shopping_cart_successfully() throws InterruptedException {
        String exVerificationResult = nopData.getCellData(allVerification,"VerifyShoppingCart",2).trim();
       String actualVerificationResult = checkoutPage.verifyNumberOfProductAddInMiniShoppingCart();
       try{
           Assert.assertEquals(exVerificationResult,actualVerificationResult);
           ExtentCucumberAdapter.addTestStepLog("User able to add product in mini shopping cart successfully");
        }catch (Exception e){
           ExtentCucumberAdapter.addTestStepLog("User unable to add product in mini shopping cart");
       }
    }

    @When("Click on checkout button in my cart page")
    public void click_on_checkout_button_in_my_cart_page() throws Throwable {
        checkoutPage.miniShoppingCart();
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
        checkoutPage.customerAddressContinueButton();
    }

    @And("Click continue button at shipping method section in checkout page")
    public void click_continue_button_at_shipping_method_section_in_checkout_page() throws Throwable {
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

    @And("Click confirm button at confirm order section in checkout page")
    public void click_confirm_button_at_confirm_order_section_in_checkout_page() throws Throwable {
        Thread.sleep(1000);
        checkoutPage.scrollPosition();
        checkoutPage.termsConditions();
        checkoutPage.confirmOrderButton();

    }
    @Then("Verify that my order placed successfully")
    public void verify_that_my_order_placed_successfully() throws Throwable {
        String exVerificationMSG = nopData.getCellData(allVerification, "VerifyOrder", 2).trim();
        String verify = checkoutPage.confirmOrderSuccessfulPage();
        try{
            Assert.assertEquals(exVerificationMSG, verify);
            ExtentCucumberAdapter.addTestStepLog("User is able to place an order successfully.");
        }catch (Exception e){
            ExtentCucumberAdapter.addTestStepLog("Unable to place an order");
        }
    }
}
