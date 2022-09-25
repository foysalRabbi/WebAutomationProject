package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    private final By loginLink=By.xpath("//a[contains(text(),'Log in')]");
    private final By username = By.xpath("//*[@id='Username']");
    private final By password = By.xpath("//*[@id ='Password']");
    private final By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    private final By validation = By.xpath("//button[contains(text(),'Log out')]");



    public void loginMenuClick(){
        driver.findElement(loginLink).click();
    }
    public void usernameInput()
    {
        driver.findElement(username).sendKeys("abc@gmail.com");
    }
    public void passwordInput()
    {
        driver.findElement(password).sendKeys("abc@gmail.com");
    }
    public void loginButtonClick()
    {
        driver.findElement(loginBtn).click();
    }

    public void validationLoginPage()
    {
        System.out.println("This is login home page");
        
    }


}
