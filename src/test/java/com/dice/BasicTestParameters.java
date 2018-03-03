package com.dice;

import com.codeborne.selenide.Configuration;
import com.dice.settings.SqlServer;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasicTestParameters {

    Logger log;
    String userEmail = "lapasv1984@gmail.com";
    String userPassword = "Qwerty123";

    SqlServer sql = new SqlServer();

    @BeforeClass
    protected void setUpClass(ITestContext ctx){
        String testName = ctx.getCurrentXmlTest().getName();
        log = Logger.getLogger(testName);
    }

    @Parameters({"browser"})
    @BeforeClass
    public void setUp(String browser){
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
        Configuration.browser = browser;
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://www.dice.com";
        Configuration.screenshots = false;
    }
}
