package com.yta;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
  WebDriver driver;

  @FindBy(id = "add-to-cart-sauce-labs-backpack")
  WebElement addBackPackButton;

  @FindBy(id = "add-to-cart-sauce-labs-bike-light")
  WebElement addBikeLightButton;

  @FindBy(className = "shopping_cart_link")
  WebElement cartIcon;

  public ProductPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void addProductToCart() {
    addBackPackButton.click();
    addBikeLightButton.click();
  }

  public void goToCart() {
    cartIcon.click();
  }
}
