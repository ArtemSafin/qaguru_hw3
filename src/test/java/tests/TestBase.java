package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://land-book.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
//        Configuration.holdBrowserOpen = true;

    }

    @AfterEach
    public void closeWindow() {
        Selenide.closeWindow();

    }

}