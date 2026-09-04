package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationPage;
import pages.TextBoxPage;
import testdata.FormTestData;
import testdata.TextBoxTestData;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    FormTestData userTest = new FormTestData();
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxTestData textBoxUserTest = new TextBoxTestData();

    @BeforeAll
    static void setup() {
        Configuration.browserSize = System.getProperty("size", "1920x1080");
        Configuration.baseUrl = System.getProperty("base_url", "https://demoqa.com");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(List.of("--disable-dev-shm-usage", "--no-sandbox"));
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("remote_url");
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @AfterEach
    void tearsDown() {
        closeWebDriver();
    }
}
