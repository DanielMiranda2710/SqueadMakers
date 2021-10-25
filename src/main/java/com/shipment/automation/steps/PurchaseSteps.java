package com.shipment.automation.steps;
import static com.shipment.automation.utils.SpecialMethods.*;
import com.shipment.automation.pageobjects.PurchasePage;
import net.thucydides.core.annotations.Step;

public class PurchaseSteps {

    PurchasePage purchasePage = new PurchasePage();

    @Step
    public void selectProducts(){
        clickJS(purchasePage.getDriver(),purchasePage.addToCartButtonOne);
        waitFor(300);
        clickJS(purchasePage.getDriver(),purchasePage.addToCartButtonTwo);
        waitFor(300);
        clickJS(purchasePage.getDriver(),purchasePage.addToCartButtonThree);
        waitFor(1000);
        clickJS(purchasePage.getDriver(), purchasePage.cartButton);
    }
}

