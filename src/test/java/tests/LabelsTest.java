package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import object.Base;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@DisplayName("AllureTest")
public class LabelsTest extends Base {

    // Behaviors - подход для написания автотестов, заключается в аннотациях для описания действияй и автоматизации требований.

    @Test
    @Feature("Issue в репозитории")
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Story("Создание Issue")
    @Owner("Artem")
    @Severity(SeverityLevel.NORMAL)
    public void staticLabels() {

    }

    @Test
    public void dynamicLabels() {

    }

    @Step("Открытие главной страницы")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория {repo}")
    public void searchRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).submit();
        $(linkText(repo)).click();
    }

    @Step("Клик по ссылке репозитория {repo}")
    public void clickToLink(String repo) {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }

    @Attachment("Сделать скриншот")
    public byte[] takeScreenshot() {
        return (((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
    }
}