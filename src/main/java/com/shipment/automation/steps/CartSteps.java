package com.shipment.automation.steps;
import static com.shipment.automation.utils.SpecialMethods.*;
import com.shipment.automation.pageobjects.CartPage;
import net.thucydides.core.annotations.Step;

public class CartSteps {
    CartPage cartPage = new CartPage();
    @Step
    public void selectCheckout(){
        scroll(cartPage.getDriver(),cartPage.checkOutButton);
        clickJS(cartPage.getDriver(), cartPage.checkOutButton);
    }
}
