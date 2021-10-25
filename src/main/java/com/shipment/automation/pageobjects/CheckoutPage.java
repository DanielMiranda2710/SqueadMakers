package com.shipment.automation.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {
    public By firstName = By.id("first-name");
    public By lastName = By.id("last-name");
    public By zipCode = By.id("postal-code");
    public By continueButton = By.id("continue");
    public By overviewFinishButton = By.id("finish");
}
