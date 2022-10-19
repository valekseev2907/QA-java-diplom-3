import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RegisterTests extends TestBase {

    public RegisterTests(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Регистрация: проверка успешной регистрации")
    public void successfulRegWhenCorrectUserDataIsValid() {
        registerPage.openRegisterPage();
        registerPage.waitForLoadRegisterPage();
        registerPage.registerValidUser();
        loginPage.waitForLoadLoginPage();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Регистрация: проверка ошибки для некорректного пароля")
    @Description("Создаем рандомно пользователя с невалидным паролем. Проверяем сообщение об ошибке")
    public void isNotRegWhenUserPasswordIncorrectLength() {
        registerPage.openRegisterPage();
        registerPage.registerInvalidUser();
        registerPage.waitForErrorMessage();
        assertEquals("Некорректный пароль", registerPage.getErrorMessage());
    }
}