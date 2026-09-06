package testdata;

import com.github.javafaker.Faker;

public class TextBoxTestData {
    private final Faker faker = new Faker();

    public String userName = faker.name().name();
    public String invalidUserEmail = faker.internet().domainName();

    public static String userEmailLocator = "userEmail";

}
