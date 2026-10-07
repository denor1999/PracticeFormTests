package pages.components;

import com.codeborne.selenide.SelenideElement;
import testdata.FormTestData;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    FormTestData dateOfBirthTest = new FormTestData();

    private final String day = dateOfBirthTest.day;

    private final SelenideElement monthOfBirth = $(".react-datepicker__month-select");
    private final SelenideElement yearOfBirth = $(".react-datepicker__year-select");
    private final SelenideElement dayOfBirth = $(".react-datepicker__day--0" + day +
            ":not(.react-datepicker__day--outside-month)");

    public void setDateOfBirth(String month, String year) {
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        dayOfBirth.click();
    }
}
