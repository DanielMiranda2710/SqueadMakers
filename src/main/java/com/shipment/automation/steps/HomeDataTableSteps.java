package com.shipment.automation.steps;

import com.shipment.automation.pageobjects.HomePage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.shipment.automation.utils.SpecialMethods.*;

public class HomeDataTableSteps {
    HomePage homePage = new HomePage();

    @Step
    public void login(DataTable table){
        List<List<String>> rows = table.asLists(String.class);
        write(homePage.getDriver(), homePage.usernameInput, rows.get(1).get(0));
        write(homePage.getDriver(), homePage.passwordInput, rows.get(1).get(1));
        clickJS(homePage.getDriver(), homePage.loginButton);
    }
}
