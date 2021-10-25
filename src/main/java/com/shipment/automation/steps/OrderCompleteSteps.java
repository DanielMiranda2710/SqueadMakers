package com.shipment.automation.steps;
import static com.shipment.automation.utils.SpecialMethods.*;
import com.shipment.automation.pageobjects.OrderCompletePage;
import net.thucydides.core.annotations.Step;

public class OrderCompleteSteps {
    OrderCompletePage orderCompletePage = new OrderCompletePage();
    @Step
    public void validationForOrder(){
        scroll(orderCompletePage.getDriver(), orderCompletePage.ThankYouForYourOrderValidation);
        validations(orderCompletePage.getDriver(),orderCompletePage.ThankYouForYourOrderValidation,properties.getProperty("validation"));
        clickJS(orderCompletePage.getDriver(), orderCompletePage.menuButton);
        waitFor(1000);
        clickJS(orderCompletePage.getDriver(), orderCompletePage.logoutButton);
    }
}
