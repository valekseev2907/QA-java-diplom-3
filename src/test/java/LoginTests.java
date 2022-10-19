import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LoginTests extends TestBase {

    public LoginTests(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Вход: проверка входа по кнопке «Войти в аккаунт» на главной странице")
    @Description("Переходим по указанной кнопке на страницу логина с заголовком 'Вход'")
    public void buttonLogInAccountOnMainPageIsTrue() {
        mainPage.openMainPage();
        mainPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }

    @Test
    @DisplayName("Вход: проверка входа через ссылку «Личный кабинет» на главной странице")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")
    public void linkPersonalAccountOnMainPageIsTrue() {
        mainPage.openMainPage();
        mainPage.clickLinkPersonalAccount();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }

    @Test
    @DisplayName("Вход: проверка входа через кнопку 'Войти' в форме регистрации")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")
    public void linkEnterOnRegPageIsTrue() {
        registerPage.openRegisterPage();
        registerPage.waitForLoadRegisterPage();
        registerPage.clickLinkEnter();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }

    @Test
    @DisplayName("Вход: проверка входа через кнопку 'Войти' в форме восстановления пароля")
    @Description("Переходим по указанной ссылке на страницу логина с заголовком 'Вход'")

    public void linkEnterOnPasswordRecoveryPageIsTrue() {
        restorePage.openRestorePasswordPage();
        restorePage.waitForLoadRestorePage();
        restorePage.clickLinkEnter();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }
}
