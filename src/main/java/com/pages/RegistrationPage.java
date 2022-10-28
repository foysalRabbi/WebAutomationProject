package com.pages;

import com.qa.managers.FileReaderManager;
import com.qa.util.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.util.Properties;

public class RegistrationPage {

    private final String baseURL = FileReaderManager.getInstance().getConfigReader().getToNopURL();
    private WebDriver driver;
    final static By UseRegisterButton = By.xpath("//a[contains(text(),'Register')]");
    final static By genderMale = By.xpath("//*[@id='gender-male']");
    final static By genderFemale = By.xpath("//*[@id='gender-female']");

    final static By fistName = By.xpath("//*[@id='FirstName']");
    final static By lastName = By.xpath("//*[@id='LastName']");
    final static By dateOfDay= By.xpath("//*[@name='DateOfBirthDay']");
    final static By dateOfMonth = By.xpath("//*[@name='DateOfBirthMonth']");
    final static By dateOfYear = By.xpath("//*[@name='DateOfBirthYear']");
    final static By userName = By.xpath("//*[@id='Username']");
    final static By emailName = By.xpath("//*[@id='Email']");
    final static By companyName = By.xpath("//*[@id='Company']");
    final static By newsletter = By.xpath("//*[@id='Newsletter']");
    final static By password = By.xpath("//*[@id='Password']");
    final static By confirmPassword = By.xpath("//*[@id='ConfirmPassword']");
    final static By registerBtnClk = By.xpath("//*[@id='register-button']");
    final static By validationMessage = By.xpath("//*[contains(text(),'Your registration completed')]");


    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToNopURL(){
        driver.navigate().to(baseURL);
    }
    public void registerButtonClick(){
        driver.findElement(UseRegisterButton).click();
    }
    public void genderMaleRadioBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement isActive = driver.findElement(genderMale);
        wait.until(ExpectedConditions.visibilityOf(isActive));
        if (isActive.isDisplayed()) {
            if (!isActive.isSelected()) {
                isActive.click();
            } else {
                System.out.println("Newsletter checkbox already Selected");
            }
        } else {
            System.out.println("Newsletter checkbox not found");
        }
    }
    public void firstNameInput(String firstNameEx) {
        driver.findElement(fistName).sendKeys(firstNameEx);
    }

    public void lastNameInput(String lastNameEx){
        driver.findElement(lastName).sendKeys(lastNameEx);
    }

    public void dateOfBrithDayInput(String day){
        try {
            Select se = new Select(driver.findElement(dateOfDay));
            se.selectByVisibleText(day);
        } catch (NoSuchElementException e) {
            System.out.println("Birth of day " + day + " not found");
            e.printStackTrace();
        }
    }
    public void dateOfBrithMonthInput(String month){
        try {
            Select se = new Select(driver.findElement(dateOfMonth));
            se.selectByVisibleText(month);
        } catch (NoSuchElementException e) {
            System.out.println("Birth of month " + month + " not found");
            e.printStackTrace();
        }
    }
    public void dateOfBirthYearInput(String year){
        try {
            Select se = new Select(driver.findElement(dateOfYear));
            se.selectByVisibleText(year);
        } catch (NoSuchElementException e) {
            System.out.println("Birth of year " + year + " not found");
            e.printStackTrace();
        }
    }
    public void emailInput(String emailEx){
        driver.findElement(emailName).sendKeys(emailEx);
    }
    public void usernameInput(String usernameEx){
        driver.findElement(userName).sendKeys(usernameEx);
    }
    public void companyNameInput(String companyNameEx){
        driver.findElement(companyName).sendKeys(companyNameEx);
    }
    public void newsletterEnable(String newsletterEx){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement isActive = driver.findElement(newsletter);
        wait.until(ExpectedConditions.visibilityOf(isActive));
        if (isActive.isDisplayed()) {
            if (!isActive.isSelected()) {
                isActive.click();
            } else {
                System.out.println("Newsletter checkbox already Selected");
            }
        } else {
            System.out.println("Newsletter checkbox not found");
        }

    }
    public void passwordInput(String passwordEx){
        driver.findElement(password).sendKeys(passwordEx);
    }

    public void confirmPasswordInput(String confirmPasswordEx){
        driver.findElement(confirmPassword).sendKeys(confirmPasswordEx);
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
