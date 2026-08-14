package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testdata.TextBoxTestData.*;

public class SimpleFormTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void minimumFieldsEnterTest(){
        textBoxPage.openPage()
                .typeUserName(userName)
                .submitForm();

        textBoxPage.checkResults(userName);
    }

    @Test
    void invalidEmailTest(){
        textBoxPage.openPage()
                .typeUserEmail(invalidUserEmail)
                .submitForm();

        textBoxPage.checkErrorFieldCondition(userEmailLocator);
    }

}
