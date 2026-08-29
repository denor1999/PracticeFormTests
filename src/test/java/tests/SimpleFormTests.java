package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testdata.TextBoxTestData;
import testdata.TextBoxTestData.*;

import static testdata.TextBoxTestData.userEmailLocator;

public class SimpleFormTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxTestData userTest = new TextBoxTestData();

    @Test
    void minimumFieldsEnterTest(){
        textBoxPage.openPage()
                .typeUserName(userTest.userName)
                .submitForm();

        textBoxPage.checkResults(userTest.userName);
    }

    @Test
    void invalidEmailTest(){
        textBoxPage.openPage()
                .typeUserEmail(userTest.invalidUserEmail)
                .submitForm();

        textBoxPage.checkErrorFieldCondition(userEmailLocator);
    }

}
