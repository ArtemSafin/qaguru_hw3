package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirth-wrapper").$(byText(year)).click();
        $("#dateOfBirth-wrapper").$(byText(day)).click();
        $("#dateOfBirth-wrapper").$(byText(month)).click();
    }
}