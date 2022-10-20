package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    public WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;

    }
    final static By UseRegisterButton = By.xpath("//a[contains(text(),'Register')]");
    final static By fistName = By.xpath("//*[@id='FirstName']");
    final static By lastName = By.xpath("//*[@id='LastName']");
    final static By userName = By.xpath("//*[@id='Username']");
    final static By emailName = By.xpath("//*[@id='Email']");
    final static By password = By.xpath("//*[@id='Password']");
    final static By confirmPassword = By.xpath("//*[@id='ConfirmPassword']");
    final static By registerBtnClk = By.xpath("//*[@id='register-button']");
    final static By validationMessage = By.xpath("//*[contains(text(),'Your registration completed')]");

    public void registerButtonClick(){
        driver.findElement(UseRegisterButton).click();
    }
    public void firstNameInput() {
        driver.findElement(fistName).sendKeys("Rehan");
    }

    public void lastNameInput(){
        driver.findElement(lastName).sendKeys("Khan");
    }
    public void emailInput(){
        driver.findElement(emailName).sendKeys("abc123456@gmail.com");
    }
    public void usernameInput(){
        driver.findElement(userName).sendKeys("abc123446@gmail.com");
    }
    public void passwordInput(){
        driver.findElement(password).sendKeys("abc@gmail.com");
    }
    public void confirmPasswordInput(){
        driver.findElement(confirmPassword).sendKeys("abc@gmail.com");
    }
    public void registerSubmitButtonClick(){

        driver.findElement(registerBtnClk).click();
    }
    public String validationSuccessfulMessage(){
       return driver.findElement(validationMessage).getText();

    }
    public void ContinueButtonClick(){
        driver.findElement(By.xpath("//*[contains(text(),'Continue')]"));
    }

}

