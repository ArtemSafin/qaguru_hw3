package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private final SelenideElement setMonth = $(".react-datepicker__month-select");
    private final SelenideElement setYear = $(".react-datepicker__year-select");
    private final  ElementsCollection setDay = $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)");
    public void setDate(String month, String day, String year) {
        setMonth.selectOption(month);
        setYear.selectOption(year);
        setDay.find(text(day)).click();
    }
}