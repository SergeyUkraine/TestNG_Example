package com.dice.pages;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public ProfilePage loginAs(String email, String password){
        $("#email").setValue(email);
        $("#password").setValue(password);
        $(byXpath("//button[@type='submit']")).click();
        return new ProfilePage();
    }
}
