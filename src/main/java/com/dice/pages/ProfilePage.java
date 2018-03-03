package com.dice.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    public SelenideElement firstName = $("#profileContactFirstName");
    public SelenideElement lastName = $("#profileContactlastName");
    public SelenideElement phoneNumber = $("#profileContactAreaCode");

    private ProfilePage openEditProfileMode(){
        $("#editProfile").click();
        return this;
    }

    private ProfilePage saveChangedData(){
        $(byXpath("//button[@class='btn btn-default btn-lg pull-right hidden-xs hidden-sm ng-scope']")).click();
        return this;
    }

    private void setFirstName(String firstName){
        $("#contactFirstNameInput").setValue(firstName);
    }

    private void setLastName(String lastName){
        $("#contactLastNameInput").setValue(lastName);
    }

    private void setPhoneNumber(String phoneNumber){
        $("#contactPhoneNumberInput").setValue(phoneNumber);
    }

    public ProfilePage editUserData(String firstName, String lastName, String phoneNumber){
        openEditProfileMode();
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        saveChangedData();
        return this;
    }
}
