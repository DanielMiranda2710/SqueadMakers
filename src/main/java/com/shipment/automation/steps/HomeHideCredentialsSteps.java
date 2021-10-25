package com.shipment.automation.steps;

import com.shipment.automation.pageobjects.HomePage;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static com.shipment.automation.utils.SpecialMethods.*;

public class HomeHideCredentialsSteps {

    HomePage homePage = new HomePage();

    @Step
    public void openBrowser(){
        homePage.open();
    }

    @Step
    public void login(){
        configProperties();
        write(homePage.getDriver(), homePage.usernameInput, properties.getProperty("username"));
        write(homePage.getDriver(), homePage.passwordInput, properties.getProperty("password"));
        clickJS(homePage.getDriver(), homePage.loginButton);
    }


}
