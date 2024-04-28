package pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import tests.TestBase;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Класс с тестами фильтров")
public class LandBookTest extends TestBase {


    @BeforeEach
    void setUp() {
        open("");
    }

    @Test
    @DisplayName("Выбор фильтров компонентов и цвета")
    void selectOptions() {
        $("#header").$(byText("Components")).click();
        $("#header").$(byText("Hero")).click();
        $(".filter-bar-items-wrapper").$(byText("Color")).click();
        $("[data-popper-placement=top-start]").$(byText("Yellow")).click();
        $("#websites").shouldNotBe(empty);
    }

    @DisplayName("Тестирование поисковой строки")
    @ParameterizedTest(name = "Поиск объектов с названием {0}")
    @ValueSource(strings = {"Blog", "Landing", "Component"})
    void inputValuesInSearch(String searchQuery) {
        $("[type='search']").setValue(searchQuery).pressEnter();
    }

    @DisplayName("Выбор параметра из поп-апа")
    @ParameterizedTest(name = "Поиск объекта {1} в поп-апе {0}")
    @CsvSource(value = {"Typography , Display"})
    void findElementInPopUp(String buttonValue, String popupValue) {
        $(".filter-bar-items-wrapper").$(byText(buttonValue)).click();
        $("[class='dropdown-menu show']").$(byText(popupValue)).click();
    }

    static Stream<Arguments> findButtonsInHeader() {
        return  Stream.of(
                Arguments.of("Templates",
                        List.of("Blog", "Landing Page", "Other", "Portfolio", "Store")),
                Arguments.of("Components",
                        List.of("Hero", "Value proposition", "Features", "How it works", "Testimonial", "Brands", "Stats", "Pricing", "Resources", "FAQ", "Call to action", "Footer", "About us", "Case study")),
                Arguments.of("Websites",
                        List.of("Landing", "Portfolio", "Blog", "Ecommerce", "Other", "About Us", "Career", "Sign Up", "Pricing", "Case Study", "Blog Post", "Product listing", "Product page", "Made in Webflow"))
        );
    }

    @DisplayName("Проверка наличия кнопок в различных категориях в хедере")
    @ParameterizedTest(name = "Проверка наличия кнопок в категории {0}")
    @MethodSource
    void findButtonsInHeader(String buttonName, List<String> expectedButtons) {
        $("#header").$(byText(buttonName)).click();
        $$("[class='navbar-nav-subcategories'] li").filter(visible).shouldHave(texts(expectedButtons));
    }
}