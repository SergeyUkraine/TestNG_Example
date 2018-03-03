package com.dice.pages;

import static com.codeborne.selenide.Selenide.open;

public class MainPage{

    private MainPage openMainPage(){
        open("/");
        return this;
    }

    public LoginPage gotoLoginPage(){
        openMainPage();
        open("/dashboard/login");
        return new LoginPage();
    }
}
