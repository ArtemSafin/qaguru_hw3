package object;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class Base {
    public class BaseTest {
        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://github.com";
            Configuration.holdBrowserOpen = true;
        }

        @AfterAll
        static void afterAll() {
            Selenide.closeWindow();
        }
    }
}
