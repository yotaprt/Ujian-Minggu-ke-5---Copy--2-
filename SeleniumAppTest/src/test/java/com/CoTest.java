package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yta.CartPage;
import com.yta.CheckoutPage;
import com.yta.LoginPage;
import com.yta.ProductPage;

public class CoTest {
  WebDriver driver;
  LoginPage loginPage;
  ProductPage productPage;
  CartPage cartPage;
  CheckoutPage checkoutPage;

  @BeforeMethod
  public void setUp() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
    loginPage = new LoginPage(driver);
    productPage = new ProductPage(driver);
    cartPage = new CartPage(driver);
    checkoutPage = new CheckoutPage(driver);
  }

  @Test
  public void successCheckoutTest() {
    loginPage.login("standard_user", "secret_sauce");
    productPage.addProductToCart();
    productPage.goToCart();
    cartPage.proceedToCheckout();
    checkoutPage.checkoutInformation("Yota", "Pratama", "16411");
    checkoutPage.finishCheckout();
    Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!");
  }

  @Test
  public void missingCheckoutDetailsTest() throws InterruptedException {
    System.out.println("Missing Checkout Detail Test");
    loginPage.login("standard_user", "secret_sauce");
    Thread.sleep(1000);
    productPage.addProductToCart();
    Thread.sleep(1000);
    productPage.goToCart();
    Thread.sleep(1000);
    cartPage.proceedToCheckout();
    Thread.sleep(1000);
    checkoutPage.checkoutInformation("", "", "");
    Thread.sleep(1000);
    Assert.assertTrue(checkoutPage.getErrorMessage().contains("Error"));
  }

  // @Test
  // public void checkoutEmptyCartTest1() throws InterruptedException {
  // System.out.println("Empty Cart Test");
  // loginPage.login(("standard_user"), "secret_sauce");
  // Thread.sleep(1000);
  // productPage.goToCart();
  // Thread.sleep(1000);
  // cartPage.proceedToCheckout();
  // Thread.sleep(1000);
  // checkoutPage.checkoutInformation("Yota", "Pratama", "16411");
  // Thread.sleep(1000);
  // try {
  // Assert.assertFalse(driver.getCurrentUrl().contains("checkout-step-two.html"));
  // } catch (AssertionError e) {
  // System.out.println("Tes Gagal");
  // throw e;
  // }
  // }

  @Test
  public void checkoutEmptyCartTest() {
    System.out.println("Empty Cart Test");
    loginPage.login("standard_user", "secret_sauce");
    productPage.goToCart();

    cartPage.proceedToCheckout();
    checkoutPage.checkoutInformation("Yota", "Pratama", "16411");
    Assert.fail("Terdeteksi checkout berhasil dengan keranjang kosnog");
  }

  @AfterMethod
  public void close() {
    driver.quit();
  }

}
