package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public CheckoutPage checkoutPage;
    public WebDriver driver;
    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginPage getLoginPage()
    {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public RegisterPage getRegisterPage()
    {
        registerPage = new RegisterPage(driver);
        return registerPage;
    }
    public CheckoutPage getCheckoutPage(){
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

}
