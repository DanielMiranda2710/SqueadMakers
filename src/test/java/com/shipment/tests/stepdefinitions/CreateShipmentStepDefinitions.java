package com.shipment.tests.stepdefinitions;

import com.shipment.automation.models.DataInjection;
import com.shipment.automation.steps.*;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class CreateShipmentStepDefinitions {

    DataInjection dataInjection = new DataInjection();

    @Steps
    HomeHideCredentialsSteps homeHideCredentialsSteps;
    @Steps
    PurchaseSteps purchaseSteps;
    @Steps
    CartSteps cartSteps;
    @Steps
    CheckoutSteps checkoutSteps;
    @Steps
    OrderCompleteSteps orderCompleteSteps;
    @Steps
    HomeDataTableSteps homeDataTableSteps;

    @Given("^that a web user wants to buy products in swaglabs$")
    public void thatAWebUserWantsToBuyProductsInSwaglabs() {
        homeHideCredentialsSteps.openBrowser();
    }


    @When("^he logs in$")
    public void heLogsIn() {
        homeHideCredentialsSteps.login();
    }

    @When("^he selects the products he wants to buy$")
    public void heSelectsTheProductsHeWantsToBuy() {
        purchaseSteps.selectProducts();
        cartSteps.selectCheckout();
        checkoutSteps.fillFormHideInfo();
    }

    @Then("^he should see the purchase order$")
    public void heShouldSeeThePurchaseOrder() {
        orderCompleteSteps.validationForOrder();
    }

    @When("^he logs in him correct credentials he selects the products that he wants to buy$")
    public void heLogsInHimCorrectCredentialsHeSelectsTheProductsThatHeWantsToBuy(DataTable table) {
        homeDataTableSteps.login(table);
        purchaseSteps.selectProducts();
        cartSteps.selectCheckout();
        checkoutSteps.fillFormDataTable(table);
    }

    @Then("^he should see the purchase order correctly$")
    public void heShouldSeeThePurchaseOrderCorrectly() {
    }


}
