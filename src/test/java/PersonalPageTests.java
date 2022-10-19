import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PersonalPageTests extends TestBase{

    public PersonalPageTests(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода в 'Личный кабинет' с главной страницы")
    public void transferPersonalPageIsTrue() {
        mainPage.openMainPage();
        mainPage.clickLinkPersonalAccount();
        loginPage.waitForLoadLoginPage();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на ссылку «Конструктор»")
    @Description("Проверка перехода по указанной ссылке на главную страницу с конструктором")
    public void transferOnLinkConstructorIsTrue() {
        loginPage.openLoginPage();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.clickLinkPersonalAccount();
        personalPage.checkSuccessGoToPersonalAccount();
        personalPage.clickConstructorLink();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип")
    @Description("Проверка перехода по клику на логотип на главную страницу с конструктором")
    public void transferOnLogoIsTrue() {
        loginPage.openLoginPage();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.clickLinkPersonalAccount();
        personalPage.checkSuccessGoToPersonalAccount();
        personalPage.clickLogo();
        mainPage.waitForLoadMainPage();
        assertEquals("Оформить заказ", mainPage.findCreateOrderButton());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверка выхода по кнопке «Выход» в личном кабинете")
    public void exitFromAccountIsTrue() {
        loginPage.openLoginPage();
        loginPage.waitForLoadLoginPage();
        loginPage.login();
        mainPage.clickLinkPersonalAccount();
        personalPage.waitForLoadAccountPage();
        personalPage.clickExitButton();
        loginPage.waitForLoadLoginPage();
        assertEquals(loginPage.getUrl(), driver.getCurrentUrl());
    }
}
