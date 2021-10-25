package com.shipment.tests.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.shipment.tests.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
tags = "@smokeTest or @regression")
public class CreateShipmentRunner {
}
