package com.dice;

import com.codeborne.selenide.Condition;
import com.dice.pages.MainPage;
import com.dice.pages.ProfilePage;
import com.dice.settings.SqlServer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.dataproviders.ProfileData;


public class EditProfileTest extends BasicTestParameters{

    @BeforeMethod()
    public void openSignInPage(){
        new MainPage()
                .gotoLoginPage()
                .loginAs(userEmail, userPassword)
        .editUserData("firstname", "lastname", "(111) 111-1111");
    }

    @Test(dataProvider = "editProfileData", dataProviderClass = ProfileData.class)
    public void testCanEditUserProfileData(String firstName, String lastName, String phoneNumber){
        new ProfilePage()
                .editUserData(firstName, lastName, phoneNumber);

        new ProfilePage().firstName.shouldHave(Condition.text(firstName));
        new ProfilePage().lastName.shouldHave(Condition.text(lastName));
        new ProfilePage().phoneNumber.shouldHave(Condition.text(phoneNumber));

        Assert.assertEquals(sql.connectionToDatabase(SqlServer.getFirstName, userEmail), firstName);
        Assert.assertEquals(sql.connectionToDatabase(SqlServer.getLastName, userEmail), lastName);
    }
}
