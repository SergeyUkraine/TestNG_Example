package test.dataproviders;

import org.testng.annotations.DataProvider;

public class ProfileData {

    @DataProvider
    public static Object[][] editProfileData() {
        return new Object[][]{
                {"Sergey", "Lapa", "(123) 456-7890"}
        };
    }

}
