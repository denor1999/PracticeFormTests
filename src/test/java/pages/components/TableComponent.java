package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {
    public void checkResults(String value) {
        $(".table").shouldHave(text(value));
    }
}
