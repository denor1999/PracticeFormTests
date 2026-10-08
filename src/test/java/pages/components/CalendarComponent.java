package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select");
    private final SelenideElement yearOfBirth = $(".react-datepicker__year-select");

    private final String dayOfBirth = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    public void setDateOfBirth(String day, String month, String year) {
        SelenideElement dayOfBirthFormatted = $(String.format(dayOfBirth, day));
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        dayOfBirthFormatted.click();
    }
}
