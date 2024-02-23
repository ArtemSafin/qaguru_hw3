package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void findJUnitOnGithubTest() {

        // открыть главную станицу
        open("");
        // ввести в инпут поиска "selenide" нажать enter
        $("[placeholder='Search or jump to...']").$(byText("Search or jump to...")).click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий
        $("[data-testid='results-list']").$(byText("selenide/")).click();
        // перейти в wiki
        $("#wiki-tab").click();

        // раскрыть весь список в баре и кликнуть на SoftAssertions
        $(".wiki-rightbar").$(byText("Show 3 more pages…")).click();
        $(".wiki-rightbar").$(byText("SoftAssertions")).click();

        // проверить наличие кода для JUnit5
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """)).shouldBe(visible);

    }
}