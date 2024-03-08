package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirth-wrapper").$(byText("July")).click();
        $("#dateOfBirth-wrapper").$(byText("1990")).click();
        $("#dateOfBirth-wrapper").$(byText("17")).click();
    }
}
