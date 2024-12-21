package com;

import com.yta.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    ChromeOptions options;

    @BeforeMethod
    public void setUp() {
        options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginUsernameInvalidTest() throws InterruptedException {
        System.out.println("=== Login Test username salah === ");
        loginPage.login("invalid_user", "secret_sauce");
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.getMessageError().contains("Epic sadface"));
        loginPage.clearAndEnterCredentials("invalid_user", "secret_sauce");
    }

    @Test
    public void loginPasswordInvalidTest() throws InterruptedException {
        System.out.println("Login test gagal pasword");
        loginPage.login("standard_user", "wrong_password");
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.getMessageError().contains("Epic sadface"));
        loginPage.clearAndEnterCredentials("standard_user", "wrong_password");
    }

    @Test
    public void emptyLoginTest() throws InterruptedException {
        System.out.println("Login test empty");
        loginPage.login("", "");
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.getMessageError().contains("Epic sadface"));
        loginPage.clearAndEnterCredentials("", "");
    }

    @Test
    public void loginTestSuccess() throws InterruptedException {
        System.out.println("=== Login Test Success === ");
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"));
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
