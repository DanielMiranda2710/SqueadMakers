package com.shipment.automation.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PurchasePage extends PageObject {
    public By addToCartButtonOne = By.xpath("(//button[text()='Add to cart'])[1]");
    public By addToCartButtonTwo = By.xpath("(//button[text()='Add to cart'])[2]");
    public By addToCartButtonThree = By.xpath("(//button[text()='Add to cart'])[3]");
    public By cartButton = By.xpath("//a[@class='shopping_cart_link']");
}
