package test.dataproviders;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider
    public static Object[][] validLoginData() {
        return new Object[][]{
                {"lapasv1984@gmail.com", "Qwerty123"}
        };
    }

    @DataProvider
    public static Object[][] invalidLoginData() {
        return new Object[][]{
                {"", "Qwerty123", "Enter a valid email."},
                {"lapasv198@gmail.com", "Qwerty123", "Email and/or password incorrect."},
                {"lapasv1984 @gmail.com", "Qwerty123", "Enter a valid email."},
                {"lapasv1984@gmail.com", "", "8 character minimum with at least 1 number and 1 letter."},
                {"lapasv1984@gmail.com", "       ", "8 character minimum with at least 1 number and 1 letter."},
                {"lapasv1984@gmail.com", "Qwerty1234", "Email and/or password incorrect."}
        };
    }
}
