package com.shipment.automation.steps;
import static com.shipment.automation.utils.SpecialMethods.*;
import com.shipment.automation.pageobjects.CheckoutPage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();

    @Step
    public void fillFormHideInfo(){
        scroll(checkoutPage.getDriver(), checkoutPage.firstName);
        clickJS(checkoutPage.getDriver(),checkoutPage.continueButton);
        configProperties();
        write(checkoutPage.getDriver(), checkoutPage.firstName, properties.getProperty("firstName"));
        write(checkoutPage.getDriver(), checkoutPage.lastName, properties.getProperty("lastName"));
        write(checkoutPage.getDriver(), checkoutPage.zipCode, properties.getProperty("zipCode"));
        scroll(checkoutPage.getDriver(), checkoutPage.continueButton);
        clickJS(checkoutPage.getDriver(),checkoutPage.continueButton);
        scroll(checkoutPage.getDriver(), checkoutPage.overviewFinishButton);
        clickJS(checkoutPage.getDriver(), checkoutPage.overviewFinishButton);
    }

    @Step
    public void fillFormDataTable(DataTable table){
        List<List<String>> rows = table.asLists(String.class);
        scroll(checkoutPage.getDriver(), checkoutPage.firstName);
        clickJS(checkoutPage.getDriver(),checkoutPage.continueButton);
        write(checkoutPage.getDriver(), checkoutPage.firstName, rows.get(1).get(2));
        write(checkoutPage.getDriver(), checkoutPage.lastName, rows.get(1).get(3));
        write(checkoutPage.getDriver(), checkoutPage.zipCode, rows.get(1).get(4));
        scroll(checkoutPage.getDriver(), checkoutPage.continueButton);
        clickJS(checkoutPage.getDriver(),checkoutPage.continueButton);
        scroll(checkoutPage.getDriver(), checkoutPage.overviewFinishButton);
        clickJS(checkoutPage.getDriver(), checkoutPage.overviewFinishButton);
    }
}
