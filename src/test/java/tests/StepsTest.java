package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import object.Base;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@DisplayName("AllureTest")
public class StepsTest extends Base {

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