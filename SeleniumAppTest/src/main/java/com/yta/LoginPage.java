package com.yta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = ".error-message-container")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public String getMessageError() {
        return errorMessage.getText();
    }

    public String getUsernameValue() {
        return usernameField.getAttribute("value");
    }

    public void clearAndEnterCredentials(String username, String password) {
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    // public LoginPage(WebDriver driver) {
    // this.driver = driver;
    // }

    // public void login(String username, String password) {
    // try {
    // driver.get("https://www.saucedemo.com");
    // WebElement usernameField = driver.findElement(By.id("user-name"));
    // WebElement passwordField = driver.findElement(By.id("password"));
    // WebElement loginButton = driver.findElement(By.id("login-button"));

    // usernameField.sendKeys(username);
    // passwordField.sendKeys(password);
    // loginButton.click();
    // } catch (NoSuchElementException e) {
    // throw new AssertionError("Failed to login: " + e.getMessage());
    // }
    // }

}
