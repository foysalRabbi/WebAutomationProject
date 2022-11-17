package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    private WebDriver driver;

    private final By loginLink=By.xpath("//a[contains(text(),'Log in')]");
    private final By username = By.xpath("//*[@id='Username']");
    private final By password = By.xpath("//*[@id ='Password']");
    private final By loginBtn = By.xpath("//button[contains(text(),'Log in')]");
    private final By validation = By.xpath("//*[text()='Log out']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void loginMenuClick(){
        WebElement el = driver.findElement(loginLink);
        el.click();
    }
    public void usernameInput(String str)
    {
        WebElement el = driver.findElement(username);
        el.clear();
        el.sendKeys(str);
    }
    public void passwordInput(String str)
    {
        WebElement el = driver.findElement(password);
        el.clear();
        el.sendKeys(str);
    }
    public void loginButtonClick()
    {
        WebElement element = driver.findElement(username);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

       driver.findElement(loginBtn).click();
    }
    public String validationLoginPage()
    {
        return driver.findElement(validation).getText();

    }
}
