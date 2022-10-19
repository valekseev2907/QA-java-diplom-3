package testdata.models;

import com.github.javafaker.Faker;
import lombok.Getter;

@Getter
public class User {

    private final String name;
    private final String email;
    private final String password;

    static Faker faker = new Faker();
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User getFakeUser() {
        return new User(
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.internet().password(6, 20)
        );
    }

    public static User getFakeUserWithShortPassword() {
        return new User(
                faker.name().firstName(),
                faker.internet().emailAddress(),
                faker.internet().password(1, 5)
        );
    }

    public static User getValidUser() {
        return new User(
                "Valentin",
                "valekseev@yandex.ru",
                "111111"
        );
    }
}
