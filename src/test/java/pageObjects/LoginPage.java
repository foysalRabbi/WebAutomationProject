package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    private final By searchBox = By.xpath("//*[@id='small-searchterms']");
    private final By searchBtnClk = By.xpath("//button[contains(text(),'Search')]");
    private final By addToCartSearch = By.xpath("//a[contains(text(),'White MacBook Pro 13-inch')]");
    private final By addToDetails = By.xpath("//*[@id='add-to-cart-button-58']");


    public void loginMenuClick(){
        driver.findElement(loginLink).click();
    }
    public void usernameInput(String str)
    {
        driver.findElement(username).sendKeys(str);
    }
    public void passwordInput(String str)
    {
        driver.findElement(password).sendKeys(str);
    }
    public void loginButtonClick()
    {
        WebElement element = driver.findElement(loginBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(loginBtn).click();
    }

    public String validationLoginPage()
    {
        return driver.findElement(By.xpath("//a[@href='/logout']")).getText();
        
    }
    public void searchInputBox(String str){
        driver.findElement(searchBox).sendKeys(str);
    }
    public void searchButtonClick(){
        driver.findElement(searchBtnClk).click();
    }
    public void addToCartButtonClick(){
        driver.findElement(addToCartSearch).click();
    }
    public void addToCartForMiniShoppingCart(){
            WebElement element = driver.findElement(addToDetails);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            driver.findElement(addToDetails).click();
    }


}
