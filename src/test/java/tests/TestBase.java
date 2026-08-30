package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import pages.TextBoxPage;
import testdata.FormTestData;
import testdata.TextBoxTestData;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxTestData textBoxUserTest = new TextBoxTestData();

    @BeforeAll
    static void setup() {
        Configuration.browserVersion = "151.0";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

}
