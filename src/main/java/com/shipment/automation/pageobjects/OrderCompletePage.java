package com.shipment.automation.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class OrderCompletePage extends PageObject {
    public By ThankYouForYourOrderValidation = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
    public By menuButton = By.id("react-burger-menu-btn");
    public By logoutButton = By.id("logout_sidebar_link");

}
