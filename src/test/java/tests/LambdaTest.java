package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import object.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@DisplayName("AllureTest")
public class LambdaTest extends Base {

    static final String REPOSITORY = "ArtemSafin/qaguru_hw3";
    static final int ISSUE = 2;

    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открытие главной страницы", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
            $(linkText(REPOSITORY)).click();
        });
        step("Клик по ссылке репозитория" + REPOSITORY, () -> {
            $("#issues-tab").click();
        });
        step("Проверка наличия Issue с номером " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        StepsTest step = new StepsTest();

        step.openMainPage();
        step.searchRepository(REPOSITORY);
        step.clickToLink(REPOSITORY);
        step.shouldSeeIssueWithNumber(ISSUE);
        step.takeScreenshot();
    }
}