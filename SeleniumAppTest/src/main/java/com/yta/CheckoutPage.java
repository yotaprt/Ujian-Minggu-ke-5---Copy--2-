package com.yta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
  WebDriver driver;

  @FindBy(id = "first-name")
  WebElement firstNameField;

  @FindBy(id = "last-name")
  WebElement lastNameField;

  @FindBy(id = "postal-code")
  WebElement postalCodeField;

  @FindBy(id = "continue")
  WebElement continueButton;

  @FindBy(id = "finish")
  WebElement finishButton;

  @FindBy(className = "complete-header")
  WebElement succcessMessage;

  @FindBy(css = "[data-test='error']")
  WebElement errorMessage;

  public CheckoutPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void checkoutInformation(String firstName, String lastName, String postalCode) {
    firstNameField.sendKeys(firstName);
    lastNameField.sendKeys(lastName);
    postalCodeField.sendKeys(postalCode);
    continueButton.click();
  }

  public void finishCheckout() {
    finishButton.click();
  }

  public String getSuccessMessage() {
    return succcessMessage.getText();
  }

  public String getErrorMessage() {
    return errorMessage.getText();
  }

}
