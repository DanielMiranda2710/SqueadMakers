package com.shipment.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {

    Faker faker = new Faker(new Locale("en-US"));

    private String name, contactName, address, zipCodeMiami, email, phoneNumber,zipCodeAlabama, weight
            , descriptionProduct, extensionNumber, cityOrigen,cityDestination, cardNumber, expectedString;
    private int cvv;

    public String getZipCodeMiami() {
        return zipCodeMiami;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public String getZipCodeAlabama() {
        return zipCodeAlabama;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    public String getWeight() {
        return weight;
    }

    public String getCityOrigen() {
        return cityOrigen;
    }

    public String getExpectedString() {
        return expectedString;
    }

    public String getCityDestination() {
        return cityDestination;
    }

    public DataInjection(){
        this.name = faker.name().firstName() + " " + faker.name().lastName();
        this.contactName = faker.name().username();
        this.address = faker.address().secondaryAddress();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.phoneNumber().cellPhone();
        this.zipCodeMiami = faker.expression("33101");
        this.zipCodeAlabama = faker.expression("35242");
        this.weight = faker.expression("50");
        this.descriptionProduct = faker.color().name();
        this.extensionNumber = faker.expression("27");
        this.cityOrigen = faker.expression("MIAMI");
        this.cityDestination = faker.expression("BIRMINGHAM");
        this.cardNumber = faker.expression("3451 7792 5488 348");
        this.cvv = 7373;
        this.expectedString = faker.expression("Pay with PayPal");
    }

    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public String getAddress() {
        return address;
    }

    public int getCvv() {
        return cvv;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
