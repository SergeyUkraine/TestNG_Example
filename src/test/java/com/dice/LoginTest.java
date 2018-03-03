package com.dice;

import com.dice.pages.LoginPage;
import com.dice.pages.MainPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.dataproviders.LoginData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginTest extends BasicTestParameters {

    @BeforeMethod
    public void openSignInPage(){
        new MainPage()
                .gotoLoginPage();
    }

    @Test(dataProvider = "validLoginData", dataProviderClass = LoginData.class)
    public void testCanLoginAsValidUser(String email, String password){
        new LoginPage()
                .loginAs(email, password);

        $("#profileContactFirstName").shouldHave(text("Sergey"));
        $("#profileContactlastName").shouldHave(text("Lapa"));

    }

    @Test(dataProvider = "invalidLoginData", dataProviderClass = LoginData.class)
    public void testCannotLoginAsInvalidUser(String email, String password, String requiredMessage){
        new LoginPage()
                .loginAs(email, password);

        $(byText(requiredMessage)).shouldBe(visible);
    }
}
